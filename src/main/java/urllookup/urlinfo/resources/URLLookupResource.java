package urllookup.urlinfo.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import urllookup.urlinfo.model.URLInfo;
import urllookup.urlinfo.service.URLLookupService;


@Path("urlinfo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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
    
    @POST
    //can add the path (/secured) to add the security to 
    //this api so that not everyone can call this
    public Response addURLInfo(List<URLInfo> urlInfos,@Context UriInfo uriInfo) {
    	URLLookupService service = new URLLookupService();
    	service.addMessages(urlInfos);
    	URI uri = uriInfo.getAbsolutePathBuilder().path("1").build();
		return Response.created(uri).build();
    	  	
    }
    
   
}
