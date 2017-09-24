package com.tcs.hyd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

public static Session HibernateUtility(){
	
	
	 Configuration cfg=new Configuration();  
	 cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
      
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();
	
	return session;
	
	
}















}
