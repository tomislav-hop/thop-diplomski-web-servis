package reciever.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("orderItems")
public interface OrderItemsInterface {

	@POST
	@Path("add")
	@Consumes("application/json")
	public String addOrderItems(String json,@QueryParam("orderId") String orderId);

	@GET
	@Path("get")
	@Consumes("application/json")
	@Produces("application/json")
	public String getOrderItem(@QueryParam("orderItemId") String OrderItemId);

	@GET
	@Path("getAll")
	@Produces("application/json")
	public String getAllOrderItems(String orderId);
}
