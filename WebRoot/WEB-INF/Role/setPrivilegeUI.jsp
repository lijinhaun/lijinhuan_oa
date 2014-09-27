<%@page import="com.lijinhuan.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script src="jquery-1.11.1.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		$("input").click(function() {
			$(this).siblings("ul").find("input").attr("checked",this.checked);
		});
	});
</script>
</head>

<body>
	现在为
	<s:text name="name" />
	设置权限
	<br />
	<%--
		  	<s:form action="roleAction_setPrivilege?id=%{id}" method="post">
		  	 	<s:checkboxlist name="privilegeIds" list="#privileges" listKey="id" listValue="name"></s:checkboxlist>
		  	 	<s:submit value="提交"/>
		  	</s:form> 
  	--%>
	<%--
  	 <input type="checkbox" id="selectAll" onclick="$('[name=privilegeIds]').attr('checked',this.toggle())">全选
  	<s:form action="roleAction_setPrivilege?id=%{id}" method="post">
	  	<s:iterator value="#privileges">
	  		<input type="checkbox" id="cb_${id}" name="privilegeIds" value="${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}" />
	  		 />
	  		<lable for="cb_${id}">${name}</lable>
	  		<br/>
	  	</s:iterator>
	  	<s:submit value="提交"/> 
  	</s:form>
  --%>
	<input type="checkbox"
		onclick="$('[name=privilegeIds]').attr('checked',this.checked)">全选
	<s:form action="roleAction_setPrivilege?id=%{id}" method="post">
		<ul>
			<s:iterator value="#application.topPrivileges">
				<li><input type="checkbox" id="cb_${id}"
					name="privilegeIds" value="${id}"
					<s:property value="%{id in privilegeIds ? 'checked' : ''}" /> />
				${name}
					<ul>
						<s:iterator value="children">
							<li><input  type="checkbox"
								id="cb_${id}" name="privilegeIds" value="${id}"
								<s:property value="%{id in privilegeIds ? 'checked' : ''}" /> />
							${name}le>
								<ul>
									<s:iterator value="children">
										<li><input  type="checkbox"
											id="cb_${id}" name="privilegeIds" value="${id}"
											<s:property value="%{id in privilegeIds ? 'checked' : ''}" /> />
										${name}</li>
									</s:iterator>
								</ul></li>
						</s:iterator>
					</ul></li>
			</s:iterator>
		</ul>
		<s:submit value="提交" />
	</s:form>
</body>
</html>
