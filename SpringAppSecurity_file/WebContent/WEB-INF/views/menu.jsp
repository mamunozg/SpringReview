
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Menu</h2>

<%-- <sec:authorize access="!isAuthenticated()"> --%>
<!-- 	Please, you have to login -->
<%-- </sec:authorize> --%>
<%-- <sec:authorize access="isAuthenticated()"> --%>
<%-- 	<sec:authentication property="principal" var="principal" /> --%>
<%-- 	<c:set var="username" value="${principal}"></c:set> --%>
<%-- 	User login (1): <c:out value="${username}"></c:out> --%>
<!-- 	<br /> -->
<%-- 	<c:url value="/logout" var="logoutUrl" /> --%>
<%-- 	<form id="logout" action="${logoutUrl}" method="post"> --%>
<%-- 		<input type="hidden" name="${_csrf.parameterName}" --%>
<%-- 			value="${_csrf.token}" /> --%>
<!-- 	</form> -->
<!-- 	<a href="javascript:document.getElementById('logout').submit()">Logout</a> -->
<%-- </sec:authorize> --%>



<sec:authorize access="isRememberMe()">
	<sec:authentication property="principal" var="principal" />
	<c:set var="username" value="${principal.username}"></c:set>
	User login (2): <c:out value="${username}"></c:out>	
	<br />
	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</sec:authorize>
<sec:authorize access="isFullyAuthenticated()">
	<sec:authentication property="principal" var="principal" />
	<c:set var="username" value="${principal}"></c:set>
	User login (3): <c:out value="${username}"></c:out>	
	<br />
	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</sec:authorize>

<a href="<c:url value="/user" />">Register USer</a>

