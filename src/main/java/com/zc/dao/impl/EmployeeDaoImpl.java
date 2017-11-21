package com.zc.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zc.dao.EmployeeDao;
import com.zc.domain.Department;
import com.zc.domain.Employee;
@Repository
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	@Override
	public Employee findExistEmployee(Employee employee) {
		String hql = "from Employee where username= ? and password= ?";
		List<Employee> list = (List<Employee>)this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if(list.size() > 0){ 
			return list.get(0);
		}else 
			return null;	
	}

	

	@Override
	public int findCount() {
		String sql = "select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(sql);
		if(list.size() > 0){
			int count = list.get(0).intValue();
			return count;
		}
		return 0;
	}



	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}



	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
		
	}



	@Override
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}



	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
		
	}



	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
		
	}








}
