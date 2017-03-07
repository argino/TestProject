
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import controller.AccessManager;

public class Application {
	private static final String PERSISTENCE_UNIT_NAME = "CustomerPU";
	private static EntityManagerFactory factory;

	public static void main(String[] args) throws JAXBException, IOException {
		// TODO Auto-generated method stub

		// System.out.println("-------- MySQL JDBC Connection Testing
		// ------------");
		//
		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		// } catch (ClassNotFoundException e) {
		// System.out.println("Where is your MySQL JDBC Driver?");
		// e.printStackTrace();
		// return;
		// }
		//
		// System.out.println("MySQL JDBC Driver Registered!");
		// Connection connection = null;
		//
		// try {
		// connection = DriverManager
		// .getConnection("jdbc:mysql://localhost:3306/mydb","root", "0000");
		//
		// } catch (SQLException e) {
		// System.out.println("Connection Failed! Check output console");
		// e.printStackTrace();
		// return;
		// }
		//
		// if (connection != null) {
		// System.out.println("You made it, take control your database now!");
		// } else {
		// System.out.println("Failed to make connection!");
		// }
		//
		// System.out.println("-----------------------------------------------");
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			EntityManager em = factory.createEntityManager();
			// read the existing entries and write to console
			Query q = em.createQuery("SELECT c FROM Customer c");
			List<Customer> customerList = q.getResultList();
			for (Customer Customer : customerList) {
				System.out.println(Customer);
			}
			System.out.println("Size: " + customerList.size());
System.out.println("----------------------------------------------------------------");
String uri = "http://localhost:8080/RestfulExample/rest/customers/list/1"; 
URL url = new URL(uri);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
XStream xStream = new XStream(new DomDriver());
List<Customer> listCustomer = new ArrayList<Customer>();

//listCustomer = access.getAllCustomers();




connection.setRequestMethod("GET");
connection.setRequestProperty("Accept", "application/xml");   
JAXBContext jc = JAXBContext.newInstance(Customer.class); 
String xml = connection.getInputStream().toString(); 
String XMLList = new XStream().toXML(xml);
xStream.alias("customer", Customer.class);
System.out.println(XMLList);
System.out.println(XMLList);
//Customer customer = (Customer) jc.createUnmarshaller().unmarshal(xml);   
connection.disconnect();


//Client client = Client.create(); 
//String uri = "http://localhost:8080/RestfulExample/rest/customers/list/1"; 
//WebResource resource = client.resource(uri); 
//ClientResponse response = resource.accept("application/xml").get(ClientResponse.class);     
//System.out.println(response.getEntity(String.class));
			// create new Customer
//			em.getTransaction().begin();
//			Customer customer = new Customer();
//			customer.setId(100);
//			customer.setFirstName("Argin");
//			customer.setLastName("Noravian");
//			customer.setEmail("argino@gmx.de");
//			customer.setPhoneNo("01735691050");
//			em.persist(customer);
//			em.getTransaction().commit();
//
//			em.close();
		
	}
}
