package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Customer;
import dto.Customers;

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
}
