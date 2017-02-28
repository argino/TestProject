package restService;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import controller.AccessManager;
import dto.Customer;
import dto.Customers;

@Path("/customers")
public class CustomerService {

	@GET
	@Path("/list")
	@Produces({MediaType.APPLICATION_JSON})
	public Response listAllCustomers() {
		String jsonList=null;
		try {
			List<Customer> listCustomer = new ArrayList<Customer>();
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
	
	@GET
	@Path("/listXML")
	@Produces({MediaType.APPLICATION_XML})
	public Response listAllCustomersXML() {
		String XMLList=null;
		try {
			XStream xStream = new XStream(new DomDriver());
			//xStream.alias("customer", Customer.class);
			List<Customer> listCustomer = new ArrayList<Customer>();
			AccessManager access = new AccessManager();
			listCustomer= access.getAllCustomers();
			System.out.println(listCustomer);
			XMLList = new XStream().toXML(listCustomer);
			System.out.println(XMLList);
//			StringWriter sw = new StringWriter();
//			JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
//			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			jaxbMarshaller.marshal(customers, sw);
//			System.out.println(sw);
//			XMLList= sw.toString();
//			System.out.println(XMLList);
//			jaxbMarshaller.marshal(XMLList, sw);
//			jaxbMarshaller.marshal(customers, System.out);
			return Response.ok(XMLList).build();
		} catch (Exception ex) {
			String result= "{\"Message\":"+ ex.getMessage() +"\"}";
			ex.printStackTrace();
			ex.getLocalizedMessage();
			return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(result).build();
		}
	}
}
