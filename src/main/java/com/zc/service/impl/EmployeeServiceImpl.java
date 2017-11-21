package com.zc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zc.dao.EmployeeDao;
import com.zc.domain.Department;
import com.zc.domain.Employee;
import com.zc.domain.PageBean;
import com.zc.service.EmployeeService;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findExistEmployee(employee);
		return existEmployee;
	}

	@Override
	public PageBean<Employee> findByPage(int currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		pageBean.setCurrPage(currPage);
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		int count = employeeDao.findCount();
		pageBean.setTotalCount(count);
		double tc = count;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}

	@Override
	public Employee findById(Employee employee) {
		
		return employeeDao.findById(employee.getEid());
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
		
	}

}
