package com.scp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.Emp;

public class EmployeeDaoImp implements EmployeeDAO {

	public SessionFactory dbSessionFactory;
	
	public SessionFactory getDbSessionFactory() {
		return dbSessionFactory;
	}

	public void setDbSessionFactory(SessionFactory dbSessionFactory) {
		this.dbSessionFactory = dbSessionFactory;
	}

	public Emp addOrUpdateEmp(Emp e) {
		Session session = dbSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(e);
		session.flush();
		transaction.commit();
		session.close();
		return e;
	}

	public Emp getEmp(int id) {
		Session session = dbSessionFactory.openSession();
		Emp e = session.get(Emp.class,id);
		session.close();
		return e;
	}

	public List<Emp> getListOfEmps() {
		Session session = dbSessionFactory.openSession();
		List<Emp> listOfEmps = session.createQuery("from Emp").list();
		session.close();
		return listOfEmps;
	}

	public boolean deleteEmp(int id) {
		Session session = dbSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(getEmp(id));
		session.flush();
		transaction.commit();
		session.close();
		return true;
	}

}
