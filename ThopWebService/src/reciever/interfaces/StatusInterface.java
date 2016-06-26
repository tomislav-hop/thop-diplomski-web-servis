package reciever.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("item")
public interface StatusInterface {

	@POST
	@Path("add")
	@Consumes("application/json")
	public String addStatus(String json);

	@GET
	@Path("get")
	@Consumes("application/json")
	@Produces("application/json")
	public String getStatus(@QueryParam("StatusId") String StatusId);

	@GET
	@Path("getAll")
	@Produces("application/json")
	public String getAllStatuses();

}
