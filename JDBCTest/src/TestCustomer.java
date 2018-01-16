import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.connection.JDBCHelper;

public class TestCustomer {
	public static void main(String[] args) {
		Connection con =  null;
		PreparedStatement psIns=null,psSel=null,psDel=null,psSrch=null;
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
				//System.out.println("established connection...con "+con);
				Scanner sc1 = new Scanner(System.in);
				Scanner sc2 = new Scanner(System.in);
		
				psIns = con.prepareStatement("insert into AccountDetails(acName,acNum,acType) values(?,?,?)");
				psSel = con.prepareStatement("select * from AccountDetails order by acName asc");
				psDel = con.prepareStatement("delete from AccountDetails where acName=?");
				psSrch = con.prepareStatement("select * from AccountDetails where acName LIKE ?");
				
				int ch = 0;
				String name,num,type;
				while(ch!=5)
				{
					System.out.println("");
					System.out.println("Press 1 to add AccountDetails data");
					System.out.println("Press 2 to delete AccountDetails data");
					System.out.println("Press 3 to list AccountDetails data");
					System.out.println("Press 4 to search");
					System.out.println("Press 5 to exit");
					System.out.println("");
					ch = sc1.nextInt();
					
					switch(ch)
					{
						case 1:
								System.out.println("add...");
								
								System.out.println("Enter name of customer");
								name = sc2.nextLine();
								System.out.println("Enter account Number of the customer (1-10) "+name);
								num = sc2.nextLine();
								System.out.println("Enter the type of account "+name);
								type = sc2.nextLine();
								
								psIns.setString(1, name);
								psIns.setString(2, num);
								psIns.setString(3, type);
								
								psIns.execute();
								
								break;

						case 2:
							System.out.println("delete...");
							System.out.println("Enter name of account you want to delete");
							name = sc2.nextLine();
							
							psDel.setString(1, name);
							psDel.execute();
							
							
							break;
						case 3:
							System.out.println("list...");
							
							psSel.execute();
							rs = psSel.getResultSet();
							System.out.println("");
							while(rs.next())
							{
								name = rs.getString("acName");
								num = rs.getString("acNum");
								type = rs.getString("acType");
								
								System.out.println("Name : "+name+" Account no : "+num+" Type of the account : "+type);
							}
							
							break;
						case 4:
							System.out.println("search...");
							System.out.println("Enter part name to search");
							name = sc2.nextLine();
							
							psSrch.setString(1,"%"+name+"%");
							psSrch.execute();
							rs = psSrch.getResultSet();
							while(rs.next())
							{
								name = rs.getString("acName");
								num = rs.getString("acNum");
								type = rs.getString("acType");
								
								System.out.println("Name : "+name+" Account no : "+num+" Type of the account : "+type);
							}
							
							break;
						case 5:
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
			JDBCHelper.close(psDel);
			JDBCHelper.close(psSel);
			JDBCHelper.close(psSrch);
			JDBCHelper.close(psIns);
			JDBCHelper.close(con);
		}
		
		

		
	}
}
