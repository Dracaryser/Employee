package com.zc.dao;

import java.util.List;

import com.zc.domain.Employee;
import com.zc.domain.PageBean;


public interface EmployeeDao {
	Employee findExistEmployee(Employee employee);

	List<Employee> findByPage(int begin, int pageSize);

	int findCount();

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
