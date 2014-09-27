<%@page import="com.lijinhuan.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	   <table border="1px"><tr><td>id</td><td>name</td><td>description</td><td>manager</td></tr>
	  		<s:iterator value="#roles"> 
	  			<tr>
					<td><s:property value="id"/></td>
					<td><s:property value="name"/></td>
					<td><s:property value="description"/></td>
					
					<td>
						<s:a action="roleAction_delete?id=%{id}">删除</s:a>
						<s:a action="roleAction_editUI?id=%{id}">更新</s:a>
						<s:a action="roleAction_setPrivilegeUI?id=%{id}">设置权限</s:a>
					</td>
				</tr>
	  		</s:iterator>
	  	</table>
	  	<s:a action="roleAction_addUI">新建</s:a>
  </body>
</html>
