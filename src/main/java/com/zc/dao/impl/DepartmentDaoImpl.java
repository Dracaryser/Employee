package com.zc.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zc.dao.DepartmentDao;
import com.zc.domain.Department;
@Repository
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
	@Override
	public int findCount() {
		String sql = "select count(*) from Department";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(sql);
		if(list.size() > 0){
			int count = list.get(0).intValue();
			return count;
		}
		return 0;
	}
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}
	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
		
	}
	@Override
	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}
	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
		
	}
	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
		
	}
	@Override
	public List<Department> findAll() {	
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}

}
