package com.scp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scp.Emp;
import com.scp.dao.EmployeeDAO;

public class EmpServiceImpl implements EmpService {

	public EmployeeDAO employeeDAO;
	
	
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public Emp addOrUpdateEmp(Emp e) {
		return employeeDAO.addOrUpdateEmp(e);
	}

	public Emp getEmp(int id) {
		return employeeDAO.getEmp(id);
	}

	public List<Emp> getListOfEmps() {
		return employeeDAO.getListOfEmps();
	}

	public boolean deleteEmp(int id) {
		return employeeDAO.deleteEmp(id);
	}

	
	
}
