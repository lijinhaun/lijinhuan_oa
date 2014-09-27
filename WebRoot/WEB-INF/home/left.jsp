<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
	<script src="jquery-1.11.1.js"></script>
	<script language="javascript" type="text/javascript">
		function toggleMune(toggleElement){
			//var uiElement = document.getElementById("div2");
			//alert(uiElememt.id);
			$(toggleElement).next().toggle();
			//alert("ok");
		}
	</script>
  </head>
  
  <body style="font-size: 12px">
    	<ul>
	    	<s:iterator value="#application.topPrivileges">
	    		<br/>
	    	 	<s:if test="#session.loginUser.hasPrivilegeByName(name)"> 
		    		<li>
			    		<div id="div1" onclick="toggleMune(this)">
			    			${name}
			    		</div>
		    			<ul>
		    				<s:iterator value="children">
		    				<br/>
		    					<s:if test="#session.loginUser.hasPrivilegeByName(name)">
			    					<li>
			    						<div >
			    							<a href="${pageContext.request.contextPath}${url}.action" target="right">${name}</a>
			    						</div>
			    					</li>
		    					</s:if>  
		    				</s:iterator>
		    			</ul>
		   			</li>
	   			 </s:if> 
	   		</s:iterator>
    	</ul>
    	<s:debug/>
  </body>
</html>
