package com.zc.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zc.domain.Department;
import com.zc.domain.Employee;
import com.zc.domain.PageBean;
import com.zc.service.DepartmentService;
import com.zc.service.EmployeeService;
@Controller
@Scope("prototype")
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	private Employee employee = new Employee();
	
	@Override
	public Employee getModel() {
		return employee;
	}
	
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	
	public String login(){
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null) {
			this.addActionError("用户名或者密码错误");
			return INPUT;
		}else{
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	int currPage = 1;
	
	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String saveUI(){
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	public String edit(){
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		employee = employeeService.findById(employee);
		return "editSuccess";
	}
	
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	public String delete(){
		employee = employeeService.findById(employee);
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
