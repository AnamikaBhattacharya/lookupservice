package urllookup.urlinfo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import urllookup.urlinfo.service.URLLookupService;


@Path("urlinfo")
@Produces(MediaType.APPLICATION_JSON)
public class URLLookupResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getURLInfo(@QueryParam("url") String url) {
    	if(null == url)
    	{
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	URLLookupService service = new URLLookupService();
    	return Response.status(Status.OK)
		.entity(service.getURLInfo(url))
		.build();
    	  	
    }
    
   
}
