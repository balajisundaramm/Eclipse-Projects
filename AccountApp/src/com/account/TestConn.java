package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestConn {

	public static void main(String[] args) {
		
		Connection con =  null;
		PreparedStatement psIns=null,psUpd=null,psSel=null,psDel=null,psSrch=null;
		ResultSet rs = null;
		try
		{
			/*
			Class.forName(Constants.DRIVERNAME);
			con = DriverManager.getConnection(Constants.URL,Constants.UID,Constants.PASS);
			System.out.println("established connection...con "+con);
			*/
			con = JDBCHelper.getConnection();
			if(con==null)
				System.out.println("Error in establishing connection...");
			else
			{
				System.out.println("established connection...con "+con);
				Scanner sc1 = new Scanner(System.in);
				Scanner sc2 = new Scanner(System.in);
		
				psIns = con.prepareStatement("insert into book(name,num_pages,rating) values(?,?,?)");
				psSel = con.prepareStatement("select * from book order by name asc");
				psDel = con.prepareStatement("delete from book where name=?");
				psUpd = con.prepareStatement("update book set rating=? where name=?");
				psSrch = con.prepareStatement("select * from book where name LIKE ?");
				
				int ch = 0;
				String name;
				int rating,numPages;
				while(ch!=6)
				{
					System.out.println("");
					System.out.println("Press 1 to insert book data");
					System.out.println("Press 2 to update book data");
					System.out.println("Press 3 to delete book data");
					System.out.println("Press 4 to list book data");
					System.out.println("Press 5 to search");
					System.out.println("Press 6 to exit");
					System.out.println("");
					ch = sc1.nextInt();
					
					switch(ch)
					{
						case 1:
								System.out.println("insert...");
								
								System.out.println("Enter name of book");
								name = sc2.nextLine();
								System.out.println("Enter rating of book (1-10) "+name);
								rating = sc1.nextInt();
								System.out.println("Enter num of pages of book "+name);
								numPages = sc1.nextInt();
								
								psIns.setString(1, name);
								psIns.setInt(2, numPages);
								psIns.setInt(3, rating);
								
								psIns.execute();
								
								break;
						case 2:
							System.out.println("update...");
							
							System.out.println("Enter name of book you want to update");
							name = sc2.nextLine();
							System.out.println("Enter new rating for the book");
							rating = sc1.nextInt();
							
							psUpd.setInt(1,rating);
							psUpd.setString(2, name);
							
							psUpd.execute();
							
							break;
						case 3:
							System.out.println("delete...");
							System.out.println("Enter name of book you want to delete");
							name = sc2.nextLine();
							
							psDel.setString(1, name);
							psDel.execute();
							
							
							break;
						case 4:
							System.out.println("list...");
							
							psSel.execute();
							rs = psSel.getResultSet();
							System.out.println("");
							while(rs.next())
							{
								name = rs.getString("name");
								rating = rs.getInt("rating");
								numPages = rs.getInt("num_pages");
								
								System.out.println("Name : "+name+" NumPages : "+numPages+" Rating : "+rating);
							}
							
							break;
						case 5:
							System.out.println("search...");
							System.out.println("Enter part name to search");
							name = sc2.nextLine();
							
							psSrch.setString(1,"%"+name+"%");
							psSrch.execute();
							rs = psSrch.getResultSet();
							while(rs.next())
							{
								name = rs.getString("name");
								rating = rs.getInt("rating");
								numPages = rs.getInt("num_pages");
								
								System.out.println("Name : "+name+" NumPages : "+numPages+" Rating : "+rating);
							}
							
							break;
						case 6:
							System.out.println("tata...");
							break;
						default:
							System.out.println("get lost...");
							break;

					}
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(psUpd);
			JDBCHelper.close(psDel);
			JDBCHelper.close(psSel);
			JDBCHelper.close(psSrch);
			JDBCHelper.close(psIns);
			JDBCHelper.close(con);
		}
		
		

	}

}
