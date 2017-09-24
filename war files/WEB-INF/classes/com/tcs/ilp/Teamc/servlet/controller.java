package com.tcs.ilp.Teamc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.tcs.ilp.Teamc.bean.BgcSchBean;
import com.tcs.ilp.Teamc.bean.AdminBean;
import com.tcs.ilp.Teamc.bean.EmpBean;
import com.tcs.ilp.Teamc.dao.Dao;


/**
 * Servlet implementation class controller
 */
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str=request.getParameter("name");
		if(str.equals("viewEmployee"))
		{
			viewEmployee(request,response);
		}
		
		else if(str.equals("editEmployee"))
		{
			editEmployee(request,response);
		}
		
		else if(str.equals("addBgcAdmin"))
		{
			addBgcAdmin(request,response);
		}
		
		else if(str.equals("viewBgcAdmin"))
		{
			viewBgcAdmin(request,response);
		}
		
		else if(str.equals("updateBgcAdmin"))
		{
			updateBgcAdmin(request,response);
		}
		else if(str.equals("ViewBgcSchedule"))
		{
		
			try {
				ViewBgcSchedule(request,response);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
}	
	
	
	
	
		public void viewEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
		{	
		ArrayList<EmpBean> al=(ArrayList<EmpBean>)Dao.viewEmployee();
		request.setAttribute("empList", al);
		request.getRequestDispatcher("viewEmp.jsp").forward(request,response);
		
	}
		
		public void editEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
		{
			System.out.println("in edit employee");
			ArrayList<EmpBean> al=(ArrayList<EmpBean>)Dao.viewEmployee();
			request.setAttribute("emplist",al);
			request.getRequestDispatcher("editEmp.jsp").forward(request,response);
		}

		
		
		public void addBgcAdmin(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
		{
			System.out.println("in Bgc Admin");
			ArrayList<EmpBean> al=(ArrayList<EmpBean>)Dao.viewEmployee();
			request.setAttribute("emplist",al);
			System.out.println("inside Bgc Admin");
			request.getRequestDispatcher("addBgc.jsp").forward(request,response);
			
		}
		
		
		public void viewBgcAdmin(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
		{	
		ArrayList<AdminBean> al=(ArrayList<AdminBean>)Dao.viewBgcAdmin();
		request.setAttribute("empList", al);
		request.getRequestDispatcher("viewBgc.jsp").forward(request,response);
		
	}
	
		public void updateBgcAdmin(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
		{
			System.out.println("in Bgc uh Admin");
			ArrayList<AdminBean> al=(ArrayList<AdminBean>)Dao.viewBgcAdmin();
			request.getSession().setAttribute("emplist",al);
			request.getRequestDispatcher("updateBgc.jsp").forward(request,response);
		}	
		public void ViewBgcSchedule(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException
		{
			System.out.println("inside view BGC Schedule");
			ArrayList<BgcSchBean> al1=(ArrayList<BgcSchBean>)Dao.ViewBgcSchedule();
			request.setAttribute("empList",al1);
	        request.getRequestDispatcher("/viewBgcSch.jsp").forward(request,response);
			
		}
		
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String str=request.getParameter("name");
		if(str.equals("addemployee"))
				{
					addemployee(request,response);
					
				}
		else if(str.equals("editOneEmployee"))
				{
			System.out.println("inside editoneemployee");
					editoneEmployee(request,response);
				}
		else if(str.equals("editingEmp"))
		{
			editingEmployee(request,response);
		}
		
		else if(str.equals("addOneBgc"))
		{
			System.out.println("inside addBgc");
			addOneBgc(request,response);
		}
		
		else if(str.equals("updateBgcAdmins"))
		{
			System.out.println("inside addBgc");
			ArrayList< AdminBean> alv = updateBgcAdmins(request,response);
			System.out.println("Arraylist retrieved");
			request.setAttribute("empList", alv);
			request.getRequestDispatcher("viewBgcAdmin.jsp").forward(request,response);
		}
		else if(str.equals("createBgcSch"))
		{
			System.out.println("inside addBgc");
			createBgcSch(request,response);
		}
	
else if(str.equals("login"))
	{
		System.out.println(str);
		login(request,response);
	}
	else if(str.equals("changepassword"))
	{
		System.out.println("inside "+str);
		changepassword(request,response);
	}

	else if(str.equals("addemployee"))
	{
		System.out.println("inside "+str);
		addemployee(request,response);
	}
}
	
		private void addemployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("Inside AddEmployee");
	String eid=request.getParameter("empid");
	int eidnum=Integer.parseInt(eid);
	String ename=request.getParameter("ename");
	System.out.println("name is:"+ename);
	String db=request.getParameter("dob");
	String dj=request.getParameter("doj");
	String division=request.getParameter("div");
	String gen=request.getParameter("sex");
	String ectc=request.getParameter("ctc");
	int sal=Integer.parseInt(ectc);
	String des=request.getParameter("desig");
	String euid=request.getParameter("UHID");
	int UID=Integer.parseInt(euid);
	String eprid=request.getParameter("ProjId");
	int PID=Integer.parseInt(eprid);
	System.out.println("name is:"+ename);
	System.out.println("Inside AddEmployee");
	EmpBean eb=new EmpBean();
	System.out.println("Inside AddEmployee");
   eb.setEmpid(eidnum);
	eb.setName(ename);
	eb.setDob(db);
	eb.setDoj(dj);
	eb.setDiv(division);
	eb.setSex(gen);
	eb.setCtc(sal);
	eb.setDesig(des);
	eb.setUHID(UID);
	eb.setProjID(PID);
	System.out.println("Inside Controller");
	System.out.println("Succesfuly set!");
	
	try {
		Dao.addEmp(eb);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	System.out.println("Employee added");
	
    RequestDispatcher rd=request.getRequestDispatcher("addempResponse.jsp");
	rd.forward(request, response);
	}
	

		private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("login()");
	int uid= Integer.parseInt(request.getParameter("userid"));
	String pwd= request.getParameter("password");
	EmpBean eb=new EmpBean();
	eb.setEmpid(uid);
	eb.setPaswrd(pwd);
	System.out.println("set data ");
	System.out.println(eb.getPaswrd());
	String desg=Dao.empLogin(eb);
	HttpSession sess = request.getSession();
	sess.setAttribute("userid", eb);

	if(desg.equals("hr")){
		System.out.println("desg is:"+desg);
	request.getRequestDispatcher("hrMainHome.html").forward(request, response);
	}
	else if (desg.equals("bgcadmin")) {
		System.out.println(desg);
		request.getRequestDispatcher("BGCADMIN_home.jsp").forward(request, response);
	}
	else if (desg.equals("uh")) {
		System.out.println(desg);
		request.getRequestDispatcher("uhMainHome.html").forward(request, response);
	}
	else if (desg.equals("false")) {
		System.out.println(desg);
		request.getRequestDispatcher("Home.html").forward(request, response);
	}
	
	
	
	else if (desg.equals("new")) {
		System.out.println(desg);
		 request.setAttribute("userid", uid);
		request.getRequestDispatcher("changePwd.jsp").forward(request, response);
	 
}
}
		private void changepassword(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	System.out.println("inside changepassword()");
	System.out.println("userid using requesr"+request.getParameter("userid"));
	int userid= Integer.parseInt(request.getParameter("userid"));
	System.out.println("userid using variable"+userid);
	String pwd= request.getParameter("newpassword");
	System.out.println("New Paswd"+pwd);
	EmpBean eb=new EmpBean();
	eb.setEmpid(userid);
	eb.setPaswrd(pwd);
	Dao.changePassword(eb);
	request.setAttribute("userid", eb);
	request.getRequestDispatcher("Home.html").forward(request, response);
	
}
		
		
		public void editoneEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			int eid=Integer.parseInt(request.getParameter("emp"));
			EmpBean eb=(EmpBean)Dao.editoneemployee(eid);
			request.setAttribute("empdtls",eb);
			
		
		RequestDispatcher rd=request.getRequestDispatcher("Editing.jsp");
		rd.forward(request, response);
		System.out.println("after editone");	
		}	
		
		public void editingEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{ 
			System.out.println("inside edit *****");
			String eid1=request.getParameter("eid");
			int eidnum=Integer.parseInt(eid1);
			String ename=request.getParameter("ename");
			String db=request.getParameter("edob");
			String dj=request.getParameter("edoj");
			String division=request.getParameter("ediv");
			String gen=request.getParameter("esex");
			String ectc=request.getParameter("ectc");
			int sal=Integer.parseInt(ectc);
			String des=request.getParameter("edesig");
			String euid1=request.getParameter("euhid");
			int UID=Integer.parseInt(euid1);
			String eprid1=request.getParameter("eprojid");
			int PID=Integer.parseInt(eprid1);
			EmpBean eb=new EmpBean();
			eb.setEmpid(eidnum);
			eb.setName(ename);
			eb.setDob(db);
			eb.setDoj(dj);
			eb.setDiv(division);
			eb.setSex(gen);
			eb.setCtc(sal);
			eb.setDesig(des);
			eb.setUHID(UID);
			eb.setProjID(PID);
			
			Dao.EditingEmployee(eb);
			viewEmployee(request, response);
			
			
		}	
		
		
		public void addOneBgc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			System.out.println("**************");
			int eid=Integer.parseInt(request.getParameter("emp1"));
			String emname=request.getParameter("ename");
			System.out.println(eid);
			System.out.println(emname);
			String emdesig=request.getParameter("edesig");
			AdminBean ab=new AdminBean();
			ab.setAdminId(eid);
			ab.setAdminName(emname);
			ab.setAdminDesig(emdesig);
			
			
			Dao.addBgcAdmin(ab);
			RequestDispatcher rd=request.getRequestDispatcher("addBgcResponse.jsp");
			rd.forward(request, response);			
		}	
		
		public ArrayList<AdminBean> updateBgcAdmins(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
		{	
		  	
			ArrayList<AdminBean> al= (ArrayList<AdminBean>)request.getSession().getAttribute("emplist");
			ArrayList<AdminBean> alv = null;
			for(int index=0;index<al.size();index++)
			{
				AdminBean eb = (AdminBean)al.get(index);
				String checkBoxStatus = request.getParameter("stats"+index);
				String status = request.getParameter("stats"+index);
				eb.setStatus(status);
				Dao.updateStatus(eb);
				alv=(ArrayList<AdminBean>)Dao.viewBgcAdmins();
				System.out.println("done");
			}
			return alv;
	}
		
		public void  createBgcSch(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
		{
		System.out.println("Inside CreateSchedule");
	    String  empid = request.getParameter("eid");
	    int empidnum=Integer.parseInt(empid);
		
	    String  bgcadmid = request.getParameter("bgcadmid");
	    int bgcadmidnum=Integer.parseInt(bgcadmid);
	    System.out.println("BGC Admin Id"+bgcadmidnum);
	    
	    String  sdate = request.getParameter("sdate");
        String  edate = request.getParameter("edate");
	    
	    String  bgcstatus = request.getParameter("BgcTestStatus");
	    
	    System.out.println("Retrieved data from form fields");
	    
	    BgcSchBean bb = new BgcSchBean();
	    bb.setEmpidnum(empidnum);
	    bb.setBgcadmidnum(bgcadmidnum);
	    bb.setSdate(sdate);
	    bb.setEdate(edate);
	    bb.setBgcstatus(bgcstatus);
	    
	    System.out.println("Created bean and set the data");
	    
	     Dao.addSch(bb);
	    
	    System.out.println("Inserted an Employee into the DataBase");
	    
	    System.out.println("Inside CreateSchedule");
	    RequestDispatcher rd  = request.getRequestDispatcher("CreateScheduleResp.jsp");
		
		rd.forward(request, response);    
    }

}	
		
	



