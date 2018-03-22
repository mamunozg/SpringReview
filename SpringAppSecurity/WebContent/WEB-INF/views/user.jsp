<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src='<c:url value="/res/js/jquery.js"/>'></script>
<script type="text/javascript">
	jQuery(document).ready(function(){
// 		alert("Recurso importado")
		jQuery(".confirm").on("click", function() {
			return confirm("Do you want delete this user?");
		})
	});
</script>
</head>
<body>

	<c:import url="/WEB-INF/views/menu.jsp"></c:import>

	<h1>User</h1>
	
<%-- 	Atributos del model: <c:out value="${msj}" /> <br/> --%>
<%-- 	Atributos del session: <c:out value="${sessionScope.rdo}" /> <br/> --%>
	
	<sf:form action="${pageContext.request.contextPath}/user/save" method="post" commandName="user">
		
	
	<table>
<%-- 		<c:if test="${admin.idAdmin ne 0}"> --%>
<%-- 			<sf:input path="idAdmin" type="hidden" /> --%>
<%-- 			<sf:input path="creationDate" type="hidden" /> --%>
<%-- 		</c:if> --%>
		<tr>
			<td>User</td>
			<td><sf:input path="user" type="text" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><sf:input path="password" type="text" /></td>
		</tr>
		<tr>
			<td>Permission</td>
			<td><sf:input path="permission" type="text" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save Changes"> </td>
		</tr>
		
	</table>
	
	</sf:form>
	<br/>
	<h3><c:out value="${rdo}"></c:out></h3> <br/><br/>
	
	<c:forEach items="${users}" var="user">		
		<c:out value="${user}" /> 
		<br/>
	</c:forEach>
</body>
</html>