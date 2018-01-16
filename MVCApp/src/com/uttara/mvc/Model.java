package com.uttara.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

	public String register(RegBean bean)
	{
		System.out.println("in register() of Model bean = "+bean);
		/*
		 * 1) input validate the user inputs in bean
		 * 2) business validation with db
		 * 3) if all validations succeed, apply BL..
		 * store bean data into database!
		 * 4) return success msg or failure msg accordingly
		 * 
		 */
		String msg = bean.validate();
		if(msg.equals(Constants.SUCCESS))
		{
			//continue with business validation!
			System.out.println("Model->register()->input validation has succeeded!");
			
			//get connection to db!
			Connection con = null;
			PreparedStatement ps_sql=null,ps_ins = null;
			ResultSet rs = null;
			try
			{
				con = JDBCHelper.getConnection();
				if(con == null)
					return "Oops db connection problem. Contact DBA! If you are DBA, leave the job!";
				
				ps_sql = con.prepareStatement("select * from register where email = ?");
				ps_sql.setString(1, bean.getEmail());
				ps_sql.execute();
				
				rs = ps_sql.getResultSet();
				
				if(rs.next())
				{
					//means there is at least 1 row!
					//email is duplicate!
					return "Oye yakappa, you duplicate! Enter new email id...";
				}
				else
				{
					//no row! email not present in table
					
					ps_ins = con.prepareStatement("insert into register(name,email,pass) values (?,?,?)");
					ps_ins.setString(1, bean.getUname());
					ps_ins.setString(2, bean.getEmail());
					ps_ins.setString(3, bean.getPass());
					ps_ins.execute();
					
					return Constants.SUCCESS;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return "Oops db failure "+e.getMessage();
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sql);
				JDBCHelper.close(ps_ins);
				JDBCHelper.close(con);
			}			
		}
		else
		{
			//error in input validation!
			return msg;
		}
		
	}

	public String authenticate(LoginBean bean) {
		
		System.out.println("in Model->authenticate() bean = "+bean);
		
		String result = bean.validate();
		if(result.equals(Constants.SUCCESS))
		{
			Connection con = null;
			PreparedStatement ps_sql = null;
			ResultSet rs = null;
			try
			{
				con = JDBCHelper.getConnection();
				if(con==null)
					return "Oops connection not established!";
				else
				{
					ps_sql = con.prepareStatement("select * from register where email = ? and pass = ?");
					ps_sql.setString(1, bean.getEmail());
					ps_sql.setString(2, bean.getPass());
					ps_sql.execute();
					
					rs = ps_sql.getResultSet();
					if(rs.next())
					{
						//authentication successful!
						return Constants.SUCCESS;
					}
					else
					{
						//authentication has failed!
						return "Your email/pass combination is invalid. You get one more chance to get it right and then we will send goondas behind you!";
					}
					
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return "Oops something bad happened "+e.getMessage();
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sql);
				JDBCHelper.close(con);
			}
			
		}
		else 
			return result;
		
		
	}
}





