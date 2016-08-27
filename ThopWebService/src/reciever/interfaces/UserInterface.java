package reciever.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("user")
public interface UserInterface {

	@POST
	@Path("login")
	@Consumes("application/json")
	public String login(String json);
}
