package com.zc.dao;

import java.util.List;

import com.zc.domain.Department;

public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void delete(Department ddepartment);

	void update(Department department);

	List<Department> findAll();

}
