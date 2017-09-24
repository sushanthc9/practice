package com.tcs.ilp.Teamc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tcs.ilp.Teamc.bean.BgcSchBean;
import com.tcs.ilp.Teamc.bean.AdminBean;
import com.tcs.ilp.Teamc.bean.EmpBean;


public class Dao {
	
public static void addEmp(EmpBean eb) throws SQLException
	{
		PreparedStatement ps=null;
		Connection con=null;
		boolean err=false;
		Statement stm = null;
		
		try
		{
			 Class.forName("oracle.jdbc.OracleDriver");
			 String ipaddr="172.25.192.71";
			 String portnum="1521";
			 String dbname="javadb";
			 String uid="H70ORAUSER3D";
			 String pwd="tcshyd";
			 String url="jdbc:oracle:thin:@"+ipaddr+":"+portnum+":"+dbname;
			 con=DriverManager.getConnection(url,uid,pwd);	
			 String query1 = "insert into emp34(empid,name,dob,doj,div,sex,ctc,desig,uhid,projid,password) values(?,?,?,?,?,?,?,?,?,?,?)" ;
				ps=con.prepareStatement(query1);
				ps.setLong(1, eb.getEmpid());
				ps.setString(2, eb.getName());
				ps.setString(3, eb.getDob());
				System.out.println("name is:"+eb.getName());
				ps.setString(4, eb.getDoj());
				ps.setString(5, eb.getDiv());
				ps.setString(6, eb.getSex());
				ps.setInt(7, eb.getCtc());
				ps.setString(8, eb.getDesig());
				ps.setInt(9, eb.getUHID());
				ps.setInt(10, eb.getProjID());
				String pwdd="changepwd@"+eb.getDob();
				System.out.println(pwdd);
				ps.setString(11,pwdd);
				 int res = ps.executeUpdate();
				  System.out.println("number of row inserted "+res);
				  System.out.println(""+eb.getName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}	
		
		finally
		{
			if(con!=null)
			{
				if(!err)
					con.commit();
				else
					con.rollback();
				
				con.close();
			}
		}
	}
	
	
public static ArrayList<EmpBean> viewEmployee()
	{
		Connection con = null;
		ArrayList<EmpBean> al=null;
		Statement stm = null;
		try
		{
			 Class.forName("oracle.jdbc.OracleDriver");
			 String ipaddr="172.25.192.71";
			 String portnum="1521";
			 String dbname="javadb";
			 String uid="H70ORAUSER3D";
			 String pwd="tcshyd";
			 String url="jdbc:oracle:thin:@"+ipaddr+":"+portnum+":"+dbname;
			 con=DriverManager.getConnection(url,uid,pwd);	
			 String qry="select *from emp34";
			 stm=con.createStatement();
			 al=new ArrayList<EmpBean>();
			 ResultSet rs=stm.executeQuery(qry);
			 System.out.println("inside view");
			  
			 while(rs.next())
			 {

				 EmpBean eb = new EmpBean();
					
					eb.setEmpid(rs.getInt(1));
					eb.setName(rs.getString(2));
					eb.setDob(rs.getString(3));
					eb.setDoj(rs.getString(4));
					eb.setDiv(rs.getString(5));
					eb.setSex(rs.getString(6));
					eb.setCtc(rs.getInt(7));
					eb.setDesig(rs.getString(8));
					eb.setUHID(rs.getInt(9));
					eb.setProjID(rs.getInt(10));
				
				 al.add(eb);
			 }
		}
		
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		finally
		{
			try{
				 if (stm != null)
				 stm.close();
				if (con != null)
				 con.close();
				}
				catch (SQLException se)
				{
				 se.printStackTrace();
				}
		}
		
		return al;
	}
	
	
public static  EmpBean editoneemployee(int eid)
{
	Connection con = null;
	
	EmpBean eb=null;
    
	ArrayList<EmpBean> al=new ArrayList<EmpBean>();
	Statement stm = null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	
		String ipaddr="172.25.192.71";
		 String portnum="1521";
		 String dbname="javadb";
		 String uid="H70ORAUSER3D";
		 String pwd="tcshyd";
		 String url="jdbc:oracle:thin:@"+ipaddr+":"+portnum+":"+dbname;
		 con=DriverManager.getConnection(url,uid,pwd);	
		String query="select *from emp34 where empid="+eid;
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			System.out.println("inside resultset");
			eb=new EmpBean();
			eb.setEmpid(rs.getInt(1));
			eb.setName(rs.getString(2));
			eb.setDob(rs.getString(3));
			eb.setDoj(rs.getString(4));
			eb.setDiv(rs.getString(5));
			eb.setSex(rs.getString(6));
			eb.setCtc(rs.getInt(7));
			eb.setDesig(rs.getString(8));
			eb.setUHID(rs.getInt(9));
			eb.setProjID(rs.getInt(10));
		}
		
		
	int num=eb.getEmpid();
	System.out.println(num);
	 }
	catch(SQLException e)
	{
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	return eb;

	
}
	
	
public static void EditingEmployee(EmpBean eb)
{
	Connection con = null;
	Statement stm = null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	
		String ipaddr="172.25.192.71";
		 String portnum="1521";
		 String dbname="javadb";
		 String uid="H70ORAUSER3D";
		 String pwd="tcshyd";
		 String url="jdbc:oracle:thin:@"+ipaddr+":"+portnum+":"+dbname;
		 con=DriverManager.getConnection(url,uid,pwd);	
		
		String query="update emp34 set ctc=?,desig=? where empid="+eb.getEmpid();
		PreparedStatement ps=con.prepareStatement(query);
		{
		ps.setInt(1, eb.getCtc());
		ps.setString(2, eb.getDesig());
		ps.executeUpdate();
		}
		
	
	 }
	catch(SQLException e)
	{
		
	} catch (ClassNotFoundException e) 
	{
		e.printStackTrace();
	}	
}



public static void addBgcAdmin(AdminBean ab)
{
	Connection con = null;
	
	Statement stm = null;
	System.out.println(ab.getAdminName());
	
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	
		String ipaddr="172.25.192.71";
		 String portnum="1521";
		 String dbname="javadb";
		 String uid="H70ORAUSER3D";
		 String pwd="tcshyd";
		 String url="jdbc:oracle:thin:@"+ipaddr+":"+portnum+":"+dbname;
		 con=DriverManager.getConnection(url,uid,pwd);	
		String query="insert into bgcadmin1(adminid,adminname,admindesig) values (?,?,?)";
			
		
		System.out.println("added123");
		PreparedStatement ps=con.prepareStatement(query);
		System.out.println("added*****");
		ps.setInt(1, ab.getAdminId());
		System.out.println("added#####");
		ps.setString(2, ab.getAdminName());
		ps.setString(3, ab.getAdminDesig());
		
		int n =ps.executeUpdate();
		System.out.println("added"+n);
		
	 }
	catch(SQLException e)
	{
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static ArrayList<AdminBean> viewBgcAdmin()
{
	Connection con = null;
	ArrayList<AdminBean> al=null;
	Statement stm = null;
	try
	{
		 Class.forName("oracle.jdbc.OracleDriver");
		 String ipaddr="172.25.192.71";
		 String portnum="1521";
		 String dbname="javadb";
		 String uid="H70ORAUSER3D";
		 String pwd="tcshyd";
		 String url="jdbc:oracle:thin:@"+ipaddr+":"+portnum+":"+dbname;
		 con=DriverManager.getConnection(url,uid,pwd);	
		 String qry="select adminid,adminname,admindesig from bgcadmin1";
		 stm=con.createStatement();
		 al=new ArrayList<AdminBean>();
		 ResultSet rs=stm.executeQuery(qry);
		 System.out.println("inside bgc view");
		  
		 while(rs.next())
		 {

			 AdminBean ab = new AdminBean();
				
				ab.setAdminId(rs.getInt(1));
				ab.setAdminName(rs.getString(2));
				ab.setAdminDesig(rs.getString(3));
				
			
			 al.add(ab);
		 }
		 
	}
	
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	
	
	finally
	{
		try{
			 if (stm != null)
			 stm.close();
			if (con != null)
			 con.close();
			}
			catch (SQLException se)
			{
			 se.printStackTrace();
			}
	}
	
	return al;
}


public static ArrayList<AdminBean> viewBgcAdmins()
{
	Connection con = null;
	ArrayList<AdminBean> al=null;
	Statement stm = null;
	try
	{
		 Class.forName("oracle.jdbc.OracleDriver");
		 String ipaddr="172.25.192.71";
		 String portnum="1521";
		 String dbname="javadb";
		 String uid="H70ORAUSER3D";
		 String pwd="tcshyd";
		 String url="jdbc:oracle:thin:@"+ipaddr+":"+portnum+":"+dbname;
		 con=DriverManager.getConnection(url,uid,pwd);	
		 String qry="select *from bgcadmin1";
		 stm=con.createStatement();
		 al=new ArrayList<AdminBean>();
		 ResultSet rs=stm.executeQuery(qry);
		 System.out.println("inside view");
		  
		 while(rs.next())
		 {

			 AdminBean eb = new AdminBean();
				
				eb.setAdminId(rs.getInt(1));
				eb.setAdminName(rs.getString(2));
				eb.setAdminDesig(rs.getString(3));
				eb.setStatus(rs.getString(4));
				
			
			 al.add(eb);
		 }
		 System.out.println("inside bgc admin view");
	}
	
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	
	
	finally
	{
		try{
			 if (stm != null)
			 stm.close();
			if (con != null)
			 con.close();
			}
			catch (SQLException se)
			{
			 se.printStackTrace();
			}
	}
	
	return al;
}


public static void updateStatus(AdminBean eb)
{
	Connection con = null;
	Statement stm = null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 String ipaddr="172.25.192.71";
		 String portnum="1521";
		 String dbname="javadb";
		 String uid="H70ORAUSER3D";
		 String pwd="tcshyd";
		 String url="jdbc:oracle:thin:@"+ipaddr+":"+portnum+":"+dbname;
		 con=DriverManager.getConnection(url,uid,pwd);	
		 System.out.println(eb.getAdminId());
		
		String query="update bgcadmin1 set status=? where adminid="+eb.getAdminId();
		PreparedStatement ps=con.prepareStatement(query);
		{
		
		ps.setString(1, eb.getStatus());
		System.out.println(eb.getStatus());
		ps.executeUpdate();
		}	
	 }
	catch(SQLException e)
	{
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}

public static void addSch(BgcSchBean bb) 
{
    Connection con = null;
	boolean err=false;
	PreparedStatement ps = null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	
		String ipaddr="172.25.192.71";
		 String portnum="1521";
		 String dbname="javadb";
		 String uid="H70ORAUSER3D";
		 String pwd="tcshyd";
		 String url="jdbc:oracle:thin:@"+ipaddr+":"+portnum+":"+dbname;
		 con=DriverManager.getConnection(url,uid,pwd);	
		System.out.println("Inside in DAO");
			
		String query1 = "insert into BgcTestSch values(Bgcid_seq.NextVal,?,?,?,?,?)" ;
		ps=con.prepareStatement(query1);
		ps.setInt(1, bb.getEmpidnum());
		ps.setInt(2, bb.getBgcadmidnum());
		ps.setString(3, bb.getSdate());
		ps.setString(4, bb.getEdate());
		ps.setString(5, bb.getBgcstatus());

  int numInsrt = ps.executeUpdate();
  System.out.println("Number of rows inserted are :::"+numInsrt);
  
  if(numInsrt != 1)
  {
	  err = true;
  }
}
catch(SQLException e)
{
	e.printStackTrace();
	err = true;
	int sqlCode = e.getErrorCode();
	System.out.println("Error Code is ::::"+sqlCode);
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
		try 
		{
    	    	if(con != null)
    	    	{
    	    		if(! err)
    	    			con.commit();
    	    		//else
//    	    			con.rollback();
//    	    		
//    	    		con.close();
    	    	}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		    	
}
}

public static ArrayList<BgcSchBean> ViewBgcSchedule()
{
	Connection con = null;
	ArrayList<BgcSchBean> al=null;
	Statement stm = null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		String ipAddr = "172.25.192.71";
		String portNum = "1521";
		String dbName = "javadb";
		String userId = "H70ORAUSER3D";
		String pwd = "tcshyd";

		String url = "jdbc:oracle:thin:@"+ipAddr+":"+portNum+":"+dbName;
		con = DriverManager.getConnection(url,userId,pwd);
		String query ="select * from Bgctestsch";
		stm=con.createStatement();
		
		 al = new ArrayList<BgcSchBean>();
		 
		
		ResultSet rs = stm.executeQuery(query);
		
		while (rs.next())
		{
			
			BgcSchBean eb = new BgcSchBean();
			
			
			eb.setEmpidnum(rs.getInt(2));
			eb.setBgcadmidnum(rs.getInt(3));
			eb.setSdate(rs.getString(4));
			eb.setEdate(rs.getString(5));
			eb.setBgcstatus(rs.getString(6));
			
			al.add(eb);
			
		}
	System.out.println("After rs");
	}
	catch(Exception ee)
	{

		ee.printStackTrace();
	}

	finally
	{
		try{
	 if (stm != null)
	 stm.close();
	if (con != null)
	 con.close();
	}
	catch (SQLException se)
	{
	 se.printStackTrace();
	}
	}
	return al;
}

public static String empLogin(EmpBean eb) {
	Connection con = null;
	String ret=null;
	Statement stm = null;
	System.out.println("inside dao");
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	
		String ipAddr = "172.25.192.71";
		String portNum = "1521";
		String dbName = "javadb";
		String userId = "H70ORAUSER3D";
		String pwd = "tcshyd";

		String url = "jdbc:oracle:thin:@"+ipAddr+":"+portNum+":"+dbName;
		con = DriverManager.getConnection(url,userId,pwd);
		System.out.println("empid=? :"+eb.getEmpid());
		System.out.println("paswrd=? :"+eb.getPaswrd());
		String query ="select  empid,password,desig,to_char(dob,'DD-MON-YY') from emp34 where empid=? and password=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setLong(1, eb.getEmpid());
		ps.setString(2, eb.getPaswrd());
		System.out.println("before resultset");
		ResultSet rs = ps.executeQuery();
		System.out.println("after resultset");
		
		if(rs.next()==true)
		{  
			String userid=rs.getString(1);
			String passwd=rs.getString(2);
		
			String dob=rs.getString(4);
			System.out.println("password:"+passwd);
			System.out.println("user id :"+userid);
			System.out.println("dob :"+dob);
			if(passwd.equals("changepwd@"+dob))
			{
				System.out.println("******");
				System.out.println(passwd);
				return "new";	
			}
			else
			ret=rs.getString(3);
		}
		else
		{
			ret="false";
		}
							
	
	}
	catch(Exception ee)
	{

		ee.printStackTrace();
	}

	finally
	{
		try{
	 if (stm != null)
	 stm.close();
	if (con != null)
	 con.close();
	}
	catch (SQLException se)
	{
	 se.printStackTrace();
	}
	}
	return ret;
			
	
	
}

public static void changePassword(EmpBean eb) {
	Connection con = null;
	String ret=null;
	Statement stm = null;
	boolean err = false;
	System.out.println("inside dao");
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String ipAddr = "172.25.192.71";
		String portNum = "1521";
		String dbName = "javadb";
		String userId = "H70ORAUSER3D";
		String pwd = "tcshyd";

		String url = "jdbc:oracle:thin:@"+ipAddr+":"+portNum+":"+dbName;
		con = DriverManager.getConnection(url,userId,pwd);
		String query ="update emp34 set password=? where empid=? ";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, eb.getPaswrd());
		ps.setInt(2, eb.getEmpid());
		int numInsrt = ps.executeUpdate();
		if(numInsrt != 1)
		  {
			  err = true;
		  }
	}
		catch(SQLException e)
	    {
	    	e.printStackTrace();
	    	err = true;    	
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    finally
	    {
	    		try 
	    		{
	    			if (stm != null)
	    				 stm.close();
		    	    	if(con != null)
		    	    	{
		    	    		if(! err)
		    	    			con.commit();
		    	    		else
		    	    			con.rollback();
		    	    		
		    	    		con.close();
		    	    	}
				}
	    		catch (SQLException e) {
				
					e.printStackTrace();
	    		}		    	
	    } 
}

	}