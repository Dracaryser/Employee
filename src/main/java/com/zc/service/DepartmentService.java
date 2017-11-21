package com.zc.service;

import java.util.List;

import com.zc.domain.Department;
import com.zc.domain.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(int currPage);

	void save(Department department);

	void delete(Department department);

	Department findById(Department department);

	void update(Department department);

	List<Department> findAll();

}
