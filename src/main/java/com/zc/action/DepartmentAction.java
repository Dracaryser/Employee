package com.zc.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zc.domain.Department;
import com.zc.domain.PageBean;
import com.zc.service.DepartmentService;
@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	
	private Department department = new Department();
	@Override
	public Department getModel() {		
		return department;
	}
	@Autowired
	DepartmentService departmentService;
	
	private int currPage = 1;
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String saveUI(){
		return "saveUI";
	}
	
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	
	public String delete(){
		department = departmentService.findById(department);
		departmentService.delete(department);
		return "deleteSuccess";
	}
	
	public String edit(){
		department = departmentService.findById(department);
		return "editSuccess";
	}
	
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
}
