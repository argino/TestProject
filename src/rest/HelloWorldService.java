package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/helloworld")
	@Produces(MediaType.TEXT_HTML)
	public Response showMessage() {
		try {
			String msg="Hello World!";
			return Response.ok(msg).build();
		} catch (Exception ex) {
			ex.getLocalizedMessage();
			return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(ex.getMessage()).build();
		}
	}
}
