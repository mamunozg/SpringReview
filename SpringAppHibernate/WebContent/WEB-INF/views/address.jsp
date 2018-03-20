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
</script>
</head>
<body>
	
	
	<h1>Address.jsp</h1>
	

	
	<sf:form action="${pageContext.request.contextPath}/address/save" method="post" commandName="address">
		
	
	<table>

<%-- 		<c:if test="${address.idAddress ne 0}"> --%>
<%-- 			<sf:input path="idAdmin" type="hidden" /> --%>
<%-- 			<sf:input path="creationDate" type="hidden" /> --%>
<%-- 		</c:if> --%>
		<tr>
			<td>Street</td>
			<td><sf:input path="street" type="text" /></td>
		</tr>
		<tr>
			<td>Zip code</td>
			<td><sf:input path="zipCode" type="text" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save Changes"> </td>
		</tr>
		
	</table>
	
	</sf:form>
	<br/>
	<h3><c:out value="${rdo}"></c:out></h3> <br/><br/>
	
	<c:forEach items="${addresses}" var="address">		
		<c:out value="${address}" /> <br/>
	</c:forEach>
</body>
</html>