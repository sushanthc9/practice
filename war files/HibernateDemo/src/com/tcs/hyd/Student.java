package com.tcs.hyd;

import java.util.*;



import org.hibernate.Query;
import org.hibernate.Session;  
  
import org.hibernate.Transaction;  


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class Student extends ActionSupport implements ModelDriven<StudentBean>,Preparable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentBean s1 ;
	private List<StudentBean> stuList;
	
	
	public StudentBean getS() {
		return s1;
	}
	public void setS(StudentBean s1) {
		this.s1 = s1;
	}
	@SuppressWarnings("unchecked")
	public String execute(){
		
			Session session=HibernateUtil.HibernateUtility();
		    Transaction t=session.beginTransaction();  
		   
		    session.save(s1);//persisting the object  
		      
		  
		    
		   // Query query = session.createQuery("from StudentBean");
		    Query query;    
		    
		  //  stuList = (List<StudentBean>)query.list();
		    
		  //  System.out.println("List  Size::" + stuList.size());
		    
		   query =session.createQuery("delete from  StudentBean where student_name = :name");
		   query.setString("name","dhdanad");
		    int i=query.executeUpdate();
		    
		    System.out.println("No of rows::" + i);
		  query = session.createQuery("from StudentBean");
		    stuList = (List<StudentBean>)query.list();
		    System.out.println("List  Size::" + stuList.size());
		    
		    t.commit();//transaction is committed
		    session.close();  
		    System.out.println("successfully saved");  
		    return "success";	      
	}
	public List<StudentBean> getStuList() {
		return stuList;
	}
	public void setStuList(List<StudentBean> stuList) {
		this.stuList = stuList;
	}
	public StudentBean getModel() {
		
		return s1;
	}
	public void prepare() throws Exception {
		s1 = new StudentBean(); 
		
	}  
}	
