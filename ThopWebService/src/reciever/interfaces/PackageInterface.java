package reciever.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("package")
public interface PackageInterface {

	@POST
	@Path("add")
	@Consumes("application/json")
	public String addPackage(String json);

	@GET
	@Path("get")
	@Consumes("application/json")
	@Produces("application/json")
	public String getPackage(@QueryParam("packageId") String packageId);

	@GET
	@Path("getAll")
	@Produces("application/json")
	public String getAllPackages();
}
