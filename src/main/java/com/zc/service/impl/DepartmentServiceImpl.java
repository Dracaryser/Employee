package com.zc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zc.dao.DepartmentDao;
import com.zc.domain.Department;
import com.zc.domain.PageBean;
import com.zc.service.DepartmentService;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public PageBean<Department> findByPage(int currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		pageBean.setCurrPage(currPage);
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		int count = departmentDao.findCount();
		pageBean.setTotalCount(count);
		double tc = count;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Department department) {
		departmentDao.save(department);
		
	}

	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
		
	}

	@Override
	public Department findById(Department department) {	
		return departmentDao.findById(department.getDid());
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
	}

	@Override
	public List<Department> findAll() {		
		return departmentDao.findAll();
	}

}
