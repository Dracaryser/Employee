<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回 </a>
</td>
</tr>
</table>
<br/>
 <br>
 <s:form id="saveForm" action="employee_save" method="post" namespace="/" theme="simple">
<table style="font-size::16px">
<tr>
  <td>员工编号：</td>
  <td><s:textfield name="eno"/></td>
</tr>
<tr>
  <td>员工姓名：</td>
  <td><s:textfield name="ename"/></td>
</tr>
<tr>
  <td>性别：</td>
  <td><s:radio name="sex" list="{'男','女'}"/></td>
</tr>
<tr>
  <td>出生日期：</td>
  <td><s:textfield name="birthday"/></td>
</tr>
<tr>
  <td>入职日期：</td>
  <td><s:textfield name="joinDate"/></td>
</tr>
<tr>
  <td>所属部门</td>
  <td><s:select name="department.did" list="list" listKey="did" listValue="dname" headKey="" headValue="--请选择--"/></td>
</tr>
<tr>
  <td>用户名：</td>
  <td><s:textfield name="username"/></td>
</tr>
<tr>
  <td>密码：</td>
  <td><s:password name="password"/></td>
</tr>
</table>
</s:form>
</body>
</html> 