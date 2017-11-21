<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#999"> 员工管理</td>
</tr>
</table>

<br/>

<table cellspacing="0" border="1" class="table1">
<thead>
   <tr><th width="100" align="center">编号</th>
  	   <th width="150" align="center">员工姓名</th>
       <th width="100" align="center">性别</th>
       <th width="150" align="center">出生日期</th>
       <th width="150" align="center">入职日期</th>
       <th width="150" align="center">所属部门</th>
   	   <th  width="200"><a href="${pageContext.request.contextPath}/employee_saveUI.action">添加</a></th><th width="450"></th></tr>
</thead>
<tbody>
<s:iterator value="list" var="e">
	<tr>
	<td align="center"><s:property value="#e.eno"/></td>
	<td align="center"><s:property value="#e.ename"/></td>
	<td align="center"><s:property value="#e.sex"/></td>
	<td align="center"><s:date name="#e.birthday" format="yyyy-MM-dd"/></td>
	<td align="center"><s:date name="#e.joinDate" format="yyyy-MM-dd"/></td>
	<td align="center"><s:property value="#e.department.dname"/></td>
	<td align="center"><a href="${pageContext.request.contextPath}/employee_edit.action?eid=<s:property value="#e.eid"/>">编辑</a></td>
	<td align="center"><a href="${pageContext.request.contextPath}/employee_delete.action?eid=<s:property value="#e.eid"/>">删除</a></td>
	</tr>
</s:iterator>
</tbody>
</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
   <span>总记录数:<s:property value="totalCount"/>&nbsp;&nbsp;每页显示：<s:property value="pageSize"/></span>
   <apan>
   	<s:if test="currPage != 1">
       <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
    </s:if>
    <s:if test="currPage != totalPage">
       <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="totalPage"/>"> [尾页]</a>&nbsp;&nbsp;
     </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>
