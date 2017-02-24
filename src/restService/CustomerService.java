package restService;

import java.awt.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import controller.AccessManager;
import dao.DBAccess;
import dto.Customer;

@Path("/customers")
public class CustomerService {

	@GET
	@Path("/list")
	@Produces({MediaType.APPLICATION_JSON})
	public Response listAllCustomers() {
		String jsonList=null;
		try {
			ArrayList<Customer> listCustomer = new ArrayList<Customer>();
			AccessManager access = new AccessManager();
			listCustomer = access.getAllCustomers();
			jsonList= new Gson().toJson(listCustomer);
			return Response.ok(listCustomer).build();
		} catch (Exception ex) {
			String result= "{\"Message\":"+ ex.getMessage() +"\"}";
			ex.getLocalizedMessage();
			return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(result).build();
		}
	}
	
	
}
