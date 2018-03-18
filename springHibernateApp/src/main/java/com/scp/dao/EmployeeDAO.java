package com.scp.dao;

import java.util.List;

import com.scp.Emp;

public interface EmployeeDAO {

	public Emp addOrUpdateEmp(Emp e);
	public Emp getEmp(int id);
	public List<Emp> getListOfEmps();
	public boolean deleteEmp(int id);
	
	
}
