package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import com.Customer;

public class CustomerDaoImpl implements CustomerDao {

	Connection con;
	
	public Customer addNewCustomer(String cname,String mobile, String address) {
		// TODO Auto-generated method stub
		
		Customer c=null;
		con = DBUtil.getCon();
		try {
			String sql = "insert into customer_detail values(seq_cust.nextval,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,cname);
			pst.setString(2, mobile);
			pst.setString(3, address);
			
			pst.execute();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return c;
		
		
		
		
	}

}
