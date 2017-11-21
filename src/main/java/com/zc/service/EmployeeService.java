package com.zc.service;

import com.zc.domain.Employee;
import com.zc.domain.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(int currPage);

	void save(Employee employee);

	Employee findById(Employee employee);

	void update(Employee employee);

	void delete(Employee employee);

}
