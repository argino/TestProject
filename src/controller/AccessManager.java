package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DBAccess;
import dao.DBConnection;
import dto.Customer;

public class AccessManager {

	public ArrayList<Customer>getAllCustomers(){
		ArrayList<Customer>customerList = new ArrayList<Customer>();
		try{
		DBConnection dbConnection = new DBConnection();
		Connection con = dbConnection.getConnection();
		DBAccess dbAccess = new DBAccess();
		customerList = dbAccess.getAllCustomers(con);
		}catch(Exception ex){
			System.out.println(""+ex.getMessage());
		}
		return customerList;
	}
	
}
