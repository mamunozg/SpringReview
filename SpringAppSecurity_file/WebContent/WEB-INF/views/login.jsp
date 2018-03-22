<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:import url="/WEB-INF/views/menu.jsp"></c:import>
	
	<h1>User Access</h1>
	<br/>
	<c:if test="${param.error != null}">
		<span style="color: red;">Failure to login. Please, check the user and/or password.</span>
	</c:if>
	
	<form name="f" action="login" method="POST">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<table>
			<tr>
				<td>User:</td>
				<td><input type="text" name="username" value=""> </td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" value=""> </td>
			</tr>
			<tr>
				<td>Remember:</td>
				<td><input type="checkbox" name="remember_me" checked="checked"> </td>
			</tr>
			<tr>
				
				<td colspan="2"><input type="submit" name="submit" value="Access"> </td>
			</tr>
		
		</table>
	
	</form>

</body>
</html>