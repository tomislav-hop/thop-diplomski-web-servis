package reciever.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("order")
public interface OrderInterface {

	@POST
	@Path("add")
	@Consumes("application/json")
	public String addOrder(String json);

	@GET
	@Path("get")
	@Consumes("application/json")
	@Produces("application/json")
	public String getOrder(@QueryParam("orderId") String PackageId);

	@GET
	@Path("getAll")
	@Produces("application/json")
	public String getAllOrders();

}
