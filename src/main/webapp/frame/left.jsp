<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<link href="dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="dtree.js"></script>
</head>

<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center">
<div class="dtree">
  <script type="text/javascript">
    d=new dTree('d');

    d.add('01','-1','Ա������ϵͳ','${pageContext.request.contextPath}/frame/right.jsp','','right');
    d.add('0101','01','������Դ��');
    d.add('010101','0101','���Ź���','${pageContext.request.contextPath}/department_findAll.action','','right');

    d.add('010102','0101','Ա������','${pageContext.request.contextPath}/employee_findAll.action','','right');
    document.write(d);
  </script>
</div>
</table>

</body>
</html>
