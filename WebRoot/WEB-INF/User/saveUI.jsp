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
    <center>
    	用户信息<br/>
    	<s:form action="userAction_%{id == 0 ? 'add' : 'edit' }" method="post">
    		<s:hidden name="id" value="%{id}"></s:hidden>
    		所属部门<s:select name="departmentId" list="#departments" listKey="id" listValue="name" headerKey="" headerValue="==请选择部门=="></s:select><br/>
    		登录名:<s:textfield name="username"/><br/>
    		姓名:<s:textfield name="name"/><br/>
    		性别：<s:radio list="{'男','女'}" name="sex"></s:radio><br/>
    		联系电话：<s:textfield name="phoneNumber"></s:textfield><br/>
    		E-main:<s:textfield name="email" /><br/>
			备注：<s:textarea name="description" /><br/>
			<br/>
			<h3>岗位设置</h3>	<br/>
			岗位	<s:select	  list="#roles" listKey="id" listValue="name" multiple="true" name="roleIds">
				</s:select>
			<br/>
			<br/>
			<br/>
			<br/>
			<span color="red">按ctrl可以多选</span>
			<br/>
		   <s:submit value="提交"/>		
		   <s:debug/>
    	</s:form>
    </center>
  </body>
</html>
