package com.uttara.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<RegBean> getUsers() {
		
		List<RegBean> list = new ArrayList<RegBean>();
	
		Connection con = null;
		PreparedStatement ps_sql = null;
		ResultSet rs = null;
		try
		{
			con = JDBCHelper.getConnection();
			ps_sql = con.prepareStatement("select * from register");
			ps_sql.execute();
			rs = ps_sql.getResultSet();
			
			while(rs.next())
			{
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pass = rs.getString("pass");
				
				RegBean bean = new RegBean();
				
				bean.setUname(name);
				bean.setEmail(email);
				bean.setPass(pass);
				
				list.add(bean);
			}
			return list;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sql);
			JDBCHelper.close(con);
		}
		
	}

	public RegBean getUserDetail(String email) {
		
		Connection con = null;
		PreparedStatement ps_sql = null;
		ResultSet rs = null;
		try
		{
			con = JDBCHelper.getConnection();
			ps_sql= con.prepareStatement("select * from register where email = ?");
			ps_sql.setString(1, email);
			ps_sql.execute();
			rs = ps_sql.getResultSet();
			RegBean bean = null;
			if(rs.next())
			{
				bean = new RegBean();
				bean.setUname(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPass(rs.getString("pass"));
				
			}
			return bean;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sql);
			JDBCHelper.close(con);
		}
		
	}

	public List<TaskBean> getTasks(String email) {
		
		/*
		 * connect to db, execute select on mytasks
		 * where the emailid of the user is used to pull the data
		 * loop over it, create 1 bean per row, add to List
		 * return list
		 * 
		 */
		List<TaskBean> tasks = new ArrayList<TaskBean>();
		TaskBean bean = null;
		
		Connection con = null;
		PreparedStatement ps_sql = null;
		ResultSet rs = null;
		try
		{
			con = JDBCHelper.getConnection();
			
			ps_sql = con.prepareStatement("select a.sl_no,a.name,a.desc from mytasks a,register b where b.sl_no = a.reg_sl and b.email = ?");
			ps_sql.setString(1,email);
			ps_sql.execute();
			
			rs = ps_sql.getResultSet();
			
			while(rs.next())
			{
				bean = new TaskBean();
				bean.setSl_no(rs.getInt("sl_no"));
				bean.setName(rs.getString("name"));
				bean.setDesc(rs.getString("desc"));
				
				tasks.add(bean);
			}
			return tasks;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sql);
			JDBCHelper.close(con);
		}
		
	}

	public String deleteTask(String email, int sl) {
		
		Connection con = null;
		PreparedStatement ps_del = null;
		try
		{
			con = JDBCHelper.getConnection();
			ps_del = con.prepareStatement("delete from mytasks where sl_no=?");
			ps_del.setInt(1, sl);
			ps_del.execute();
			return Constants.SUCCESS;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return "Oops something bad happened "+e.getMessage();
		}
		finally
		{
			JDBCHelper.close(ps_del);
			JDBCHelper.close(con);
		}
		
	}
}





