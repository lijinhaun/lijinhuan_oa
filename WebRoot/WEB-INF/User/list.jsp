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
	<script	language="javascript">
		function initpassword() {
			var confimed="确认初始化密码为1234";
			window.confirm(confimed);
		}
	</script>
  </head>
  	
  <body>
  		用户管理<br/>
  		<table border="1px" width="800">
  		<tr><td>登录名</td><td>姓名</td><td>所属部门</td><td>岗位</td><td>备注</td><td>相关操作</td></tr>
	  		<s:iterator value="#users">
				<tr>
					<td><s:property value="username"/></td>
					<td><s:property value="name"/></td>
					<td><s:property value="department.name"/></td>
					<td><s:iterator value="roles">
							<s:property value="name"/>							
						</s:iterator>
					</td>
					<td><s:property value="description"/></td>
					<td>
						<s:a action="userAction_delete?id=%{id}">删除</s:a>
		  				<s:a action="userAction_editUI?id=%{id}">修改</s:a>
		  				<s:a action="userAction_editPasswordUI?id=%{id}">修改密码</s:a>
		  				<s:a action="userAction_initPassword?id=%{id}" onclick="return initpassword()">初始化密码</s:a>
		  			</td>
				</tr>	  			
	  			
	  		</s:iterator>
  		</table>
  		<s:a action="userAction_addUI" >添加用户</s:a>
  </body>
</html>
