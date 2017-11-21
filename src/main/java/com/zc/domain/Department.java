package com.zc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="department")
public class Department {
	public Integer did;
	public String dname;
	public String ddesc;
	
	public Set<Employee> employees = new HashSet<Employee>();

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDdesc() {
		return ddesc;
	}

	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}