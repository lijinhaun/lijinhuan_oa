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
	<script language="javascript">
		function confimed() {
			var mes = "将会删除本部门及其下属部门";
			if(confirm(mes)==true) {
				return true;
			}else{
				return false;
			}
		}
	</script>
  </head>
  	
  <body>
  		<center>
  			部门列表
  			<table border="1" width="500"><tr><td>部门名称</td><td>部门号</td><td>部门介绍</td><td>上级部门</td><td>管理操作</td></tr>
  			
	  			<s:iterator value="#departments">
	  			<tr>
	  				<td>
	  					<s:a action="departmentAction_list.action?parentId=%{id}"><s:property value="name"/></s:a>
	  				</td>
	  				<td>
	  					<s:property value="id"/>
	  				</td>
	  				<td>
	  					<s:property value="description"/>
	  				</td>
	  				<td>
	  					<s:property value="parent.name"/>
	  				</td>
	  				<td>
		  				<s:a action="departmentAction_delete?id=%{id}" onclick="return confimed()">删除</s:a>
		  				<s:a action="departmentAction_editUI?id=%{id}">修改</s:a>
	  				</td>
	  			</tr>
	  			</s:iterator>
  			</table>
		  <s:a action="departmentAction_addUI?parentId=%{parentId}">添加</s:a>
		  <s:a action="departmentAction_superList?parentId=%{parentId}">返回上一级</s:a>
  		</center>
  </body>
</html>
