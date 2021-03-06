package reciever.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("item")
public interface ItemInterface {

	@POST
	@Path("add")
	@Consumes("application/json")
	public String addItem(String json);

	@GET
	@Path("get")
	@Consumes("application/json")
	@Produces("application/json")
	public String getItem(@QueryParam("itemId") String itemId);

	@GET
	@Path("getAll")
	@Produces("application/json")
	public String getAllItems();
	
	@GET
	@Path("bake")
	@Produces("application/json")
	public String getBakeTime(@QueryParam("kg") String kg, @QueryParam("itemId") String itemId);
}
