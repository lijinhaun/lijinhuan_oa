<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editPassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript">
		function checkPassword() {
			var password = document.getElementById("password").value;
			var password2 = document.getElementById("password2").value;
			if(password == password2) {
				document.editPassword.submit();
			}else {
				alert("您输入的密码错误请重新输入！");
			}
		}				
	</script>
  </head>
  
  <body>
  	<s:form action="userAction_editPassword" method="" name="editPassword">
  	<s:hidden name="id" id="%{id}"></s:hidden>
    	请输入您新密码：<s:password  name="password" id="password"/><br/>
 		请再次输入：<s:password  name="password2" id="password2"/><br/>
  		<input type="button" value="提交" onclick="checkPassword()" />
  	</s:form>
  </body>
</html>
