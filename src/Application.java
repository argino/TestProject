
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.config.ClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			System.out.println("-------- MySQL JDBC Connection Testing ------------");

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your MySQL JDBC Driver?");
				e.printStackTrace();
				return;
			}

			System.out.println("MySQL JDBC Driver Registered!");
			Connection connection = null;

			try {
				connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/mydb","root", "0000");

			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;
			}

			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
			
			System.out.println("-----------------------------------------------");
		  
			   ClientConfig config = new ClientConfig();
               Client client = ClientBuilder.newClient(config);

               WebTarget target = client.target(getBaseURI());
               // Get XML
               String xmlResponse = target.path("rest").path("todo").request()
                               .accept(MediaType.TEXT_XML).get(String.class);
               // Get XML for application
               String xmlAppResponse =target.path("rest").path("todo").request()
                               .accept(MediaType.APPLICATION_XML).get(String.class);

               // For JSON response also add the Jackson libraries to your webapplication
                               // In this case you would also change the client registration to
                               // ClientConfig config = new ClientConfig().register(JacksonFeature.class);
                               // Get JSON for application
                               // System.out.println(target.path("rest").path("todo").request()
                               // .accept(MediaType.APPLICATION_JSON).get(String.class));

               System.out.println(xmlResponse);
               System.out.println(xmlAppResponse);
       }

       private static URI getBaseURI() {
               return UriBuilder.fromUri(
                               "http://localhost:8080/_com.vogella.jersey.jaxb").build();
       }







}
