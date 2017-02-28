package controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DBAccess;
import dao.DBConnection;
import dto.Customer;
import dto.Customers;

public class AccessManager {

	public List<Customer> getAllCustomers(){
		List<Customer>customerList = new ArrayList<Customer>();
		Customers customers = new Customers();
		try{
		DBConnection dbConnection = new DBConnection();
		Connection con = dbConnection.getConnection();
		DBAccess dbAccess = new DBAccess();
		customerList = dbAccess.getAllCustomers(con);
		System.out.println("accessmanager customerList: "+customerList);
		//customers= dbAccess.getAllCustomers(con);
		}catch(Exception ex){
			System.out.println(""+ex.getMessage());
		}
		System.out.println("size: "+customerList.size());
		
		return customerList;
	}
	
}
