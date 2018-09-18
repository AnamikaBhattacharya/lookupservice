package urllookup.urlinfo.filters;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter{

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URI_PREFIX = "secured";
	@Override
	public void filter(ContainerRequestContext arg0) throws IOException {
		if(!arg0.getUriInfo().getPath().contains(SECURED_URI_PREFIX))
			return;
		List<String> authHeaders= arg0.getHeaders().get(AUTHORIZATION_HEADER);
		if(!authHeaders.isEmpty())
		{
			String authToken = authHeaders.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodedString = Base64.decodeAsString(authToken);
			StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			if("user".equals(username) && "password".equals(password))
			{
				return;
			}
		}
		System.out.println("here");
		Response res = Response.status(Status.UNAUTHORIZED)
		.entity("User cannot access the resource")
		.build();	
		arg0.abortWith(res);
		
	}

}
