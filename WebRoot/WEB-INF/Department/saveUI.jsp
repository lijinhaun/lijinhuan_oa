<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <s:form action="departmentAction_%{id > 0? 'edit' : 'add'}" method="post">
	    <s:hidden name="id" id="%{id}"></s:hidden>
	    	上级部门:<s:select name="parentId" list="#departments" listKey="id" listValue="name" headerKey="" headerValue="====请选择部门==="></s:select><br/>
	    	部门名称:<s:textfield name="name" value="%{name}"></s:textfield><br/>
	    	功能说明:<s:textarea name="description" value="%{description}" ></s:textarea><br/>
	    	<s:submit value="提交"></s:submit>
	    </s:form> 
    <s:debug/>
  </body>
</html>
