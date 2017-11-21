<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
</head>
<body>
<div align="center">
<table border="0" width="100%" cellspacing="0" cellpadding="0" id="table1">
<tr>
<td height="100"></td>
</tr>
<tr>
<td>
<img src="${pageContext.request.contextPath}/images/bg.jpg"/ style="background-repeat:no-repeat" width="2000px" height="700px">
</td>
</tr>
</table>
</div>
</body>
</html>
