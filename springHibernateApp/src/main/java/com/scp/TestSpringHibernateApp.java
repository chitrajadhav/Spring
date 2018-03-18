package com.scp;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scp.service.EmpService;

public class TestSpringHibernateApp {
	
	public static void main(String[] args) {
		
		Emp e1 = new Emp(1,"chitra","sangamner");
		Emp e2 = new Emp(2,"jyoti","pune");
		Emp e3 = new Emp(3,"saurabhi","pune");
		Emp e4 = new Emp(4,"megha","nagar");
		Emp e5 = new Emp(5,"sharayu","kolhapur");
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/SpringBeanConfig.xml");
		EmpService eservice = (EmpService) context.getBean("eService");
		eservice.addOrUpdateEmp(e1);
		eservice.addOrUpdateEmp(e2);
		eservice.addOrUpdateEmp(e3);
		eservice.addOrUpdateEmp(e4);
		eservice.addOrUpdateEmp(e5);
		
		System.out.println("------------- Employee Database ------------ ");
		display(eservice);
		System.out.println("Emp Details with id " + eservice.deleteEmp(2)+ " is deleted");
		
		display(eservice);
		Emp e=eservice.getEmp(4);
		System.out.println(e);
		

	}

	public static void display(EmpService eservice) {
		List<Emp> listOfEmployees = eservice.getListOfEmps();
		Iterator itr = listOfEmployees.iterator();
		System.out.println("------------- Employee Database After Deletion ------------ ");
		while (itr.hasNext()) {
			Emp e = (Emp) itr.next();
			System.out.println("Emp Details---- " + e);
		}

	}

}



