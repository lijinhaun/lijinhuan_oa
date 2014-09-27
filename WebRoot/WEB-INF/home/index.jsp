<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

	<frameset rows="10%,*,10%">
		<frame name="head" src="homeAction_head.action"></frame>
		<frameset cols="15%,*">
			<frame scrolling="auto" name="left" src="homeAction_left.action"></frame>
			<frame name="right" src="homeAction_right.action"></frame>
		</frameset>
		<frame name="tail" src="homeAction_tail.action"></frame>
	</frameset>
  
</html>
