package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;


public class DBAccess {
	public ArrayList<Customer> getAllCustomers(Connection con) {
		ArrayList<Customer> customersList = new ArrayList<Customer>();
		//Customers customers = new Customers();
		//customers.setCustomers(new ArrayList<Customer>());
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlStmt= "SELECT * FROM customers";
		try {
			stmt = con.prepareStatement(sqlStmt);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("personID"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setEmail(rs.getString("email"));
				customer.setPhoneNo(rs.getString("phone"));
				customersList.add(customer);
				//customers.getCustomers().add(customer);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("DBAccess customerlist: "+customersList);
		return customersList;
	}
	public Customer getCustomerById(Connection con, int personId) {
		try{
		Customer customer = new Customer();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM customers WHERE personId=?");
			stmt.setInt(1, personId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
//				if (rs.getInt("personId")==0)
//					throw new Exception(""+ new Exception().printStackTrace(null));
//				else{
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setEmail(rs.getString("email"));
				customer.setPhoneNo(rs.getString("phone"));
				customer.setId(rs.getInt("personId"));
			}
					return customer;
		//}
	}
		catch (SQLException e){
			System.out.println("Error: invalid SQL statement: "+e.getLocalizedMessage());
			e.getStackTrace();
		}
		return null;
	}
}
