package com.register;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Model {
	
	public String register(RegBean bean) {
		
		System.out.println("in model register() bean-->"+bean);
		/*
		 * 1. Input validate the bean. if it fails return the msg 
		 * which is to be displayed to user
		 * 2. Business validate connection to DB. if it fails return the msg to user
		 * 3. Apply business logic and store the data to DB
		 * 4. return Success 
		 */
		
		// Input validation
		String msg=bean.validate();
		if(msg.equals("SUCCESS")) {
			System.out.println("In model Validation succeeded");
			
		// Business validation
			Connection con=null;
			PreparedStatement ps_sql=null, ps_ins=null;
			ResultSet rs=null;
			try {
				con=JDBCHelper.getConnection();
				if(con==null) {
					return "cannot connect to DB. Contact admin!!!";
				}
				else {
					ps_sql=con.prepareStatement("select * from register where email=? and pswd=?");
					ps_sql.setString(1, bean.getEmail());
					ps_sql.setString(2, bean.getPswd());
					ps_sql.execute();
					
					rs=ps_sql.getResultSet();
				
					if(rs.next()) {
						return "Email id already taken!! enter new email id";
					}
					else {
						// business validation succeeded
						// store data into DB
						ps_ins=con.prepareStatement("insert into register (name,email,pswd) values(?,?,?)");
						ps_ins.setString(1, bean.getName());
						ps_ins.setString(2, bean.getEmail());
						ps_ins.setString(3, bean.getPswd());
						ps_ins.execute();
						
						return "SUCCESS";
						
					}
				}
				
			}
			catch (SQLException e) {
				e.printStackTrace();
				return "Oops something went wrong!"+e.getMessage();
			}
			
		}
		else {
			System.out.println("In model regiateration failed");
			return msg;
		}
	}
	
	public String login(LoginBean bean) {
		System.out.println("In model login.do...");
		
		/*
		 * 1. Input validate the bean. if it fails return the msg 
		 * which is to be displayed to user
		 * 2. Business validate connection to DB. if it fails return the msg to user
		 * 3. Apply business logic and store the data to DB
		 * 4. return Success 
		 */
		
		// Input validation
		String msg=bean.validate();
		if(msg.equals("SUCCESS")) {
			System.out.println("In model Validation succeeded");
			
		// Business validation
			Connection con=null;
			PreparedStatement ps_sql=null, ps_ins=null;
			ResultSet rs=null;
			
			try {
				con=JDBCHelper.getConnection();
				if(con==null) {
				return "cannot connect to DB. Contact admin!!!";
				}
				else {
					ps_sql=con.prepareStatement("select * from register where email=? and pswd=?");
					ps_sql.setString(1, bean.getEmail());
					ps_sql.setString(2, bean.getPswd());
					ps_sql.execute();
					
					rs=ps_sql.getResultSet();
				
					if(!rs.next()) {
						return "Email id or Password is incorrect..";
					}
					else {
					// business validation succeeded
					// forward to menu.jsp
						return "SUCCESS";

					}
					
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				return "Oops something went wrong!"+e.getMessage();
			}
		}
		else {
		System.out.println("In model login failed");
		return msg;
		}
	}
		
		
		public String editAcc(EditBean bean/*, LoginBean lbean*/){
			
			System.out.println("in model editAcc bean-->"+bean);
			/*
			 * 1. Input validate the bean. if it fails return the msg 
			 * which is to be displayed to user
			 * 2. Business validate connection to DB. if it fails return the msg to user
			 * 3. Apply business logic and store the data to DB
			 * 4. return Success 
			 */
			
			// Input validation
			String msg=bean.validate();
			if(msg.equals("SUCCESS")) {
				System.out.println("In model Validation succeeded");
				
			// Business validation
				Connection con=null;
				PreparedStatement ps_sql=null, ps_ins=null;
				ResultSet rs=null;
				try {
					con=JDBCHelper.getConnection();
					if(con==null) {
						return "cannot connect to DB. Contact admin!!!";
					}
					else {
						ps_sql=con.prepareStatement("select * from register where email=?");
						ps_sql.setString(1, bean.getEmail());
						ps_sql.execute();
						
						rs=ps_sql.getResultSet();
					
						if(!rs.next()) {
							return "Enter the corrct email id you want to edit";
						}
					
						else {
							// business validation succeeded
							// store data into DB
							System.out.println("In bussiness logic");
							ps_ins=con.prepareStatement("update register set name=?, pswd=? where email=? ");
							ps_ins.setString(1, bean.getName());
							ps_ins.setString(2, bean.getPswd());
							ps_ins.setString(3, bean.getEmail());
							
							ps_ins.execute();
							
							return "SUCCESS";
							
						}
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					return "Oops something went wrong!"+e.getMessage();
				}
				
			}
			else {
				System.out.println("In model editing failed");
				return msg;
			}
		}
}


