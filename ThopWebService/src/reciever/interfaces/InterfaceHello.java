package reciever.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("hello")
public interface InterfaceHello {
	@GET
	@Path("sayHello")
	public String sayHello(@QueryParam("name") String name);
	
	@POST
	@Path("testPost")
	@Consumes("application/json")
	public String testPost(String json);
	
	
	

}
