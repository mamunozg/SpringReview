<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" media="all" type="text/css" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<%-- <script type="text/javascript" src='<c:url value="/res/js/jquery.js"/>'></script> --%>


<script type="text/javascript">
	jQuery(document).ready(function(){
// 		alert("Recurso importado")
		jQuery(".confirm").on("click", function() {
			return confirm("Do you want delete this user?");
		});
		var path = $("#path").val();
		jQuery("#research").autocomplete({
			source: path + "/admin/json/search"
		});
		$('#ajaxSearch').click(function(event) {
	           var url = path + "/admin/json/search";
	           $.ajax({ 
	                url: url, 
	                data: { term: $("#ajaxText").val()}, 
	                success: function (data) { 
	                	$('#ajaxResult').empty();
	                    $.each(data, function(index, element) {
	                    	$('#ajaxResult').append(index, ': <b>' + element + '</b><br/>');
	                    });
	                    
	                }
	            });
	        });
		});
</script>
</head>
<body>

	<c:import url="/WEB-INF/views/menu.jsp"></c:import>

	<h1>Admin</h1>
	

		<input type="hidden"  id="path" value="${pageContext.request.contextPath}" />
		Search Admins: <input type="text"  id="research" />

	
	
<%-- 	<form action="${pageContext.request.contextPath}/admin/json/search"> --%>
<!-- 		<input type="text" name="term"> -->
<!-- 		<input type="submit"  value="test_json"> -->
<!-- 	</form> -->
	
<%-- 	Atributos del model: <c:out value="${msj}" /> <br/> --%>
<%-- 	Atributos del session: <c:out value="${sessionScope.rdo}" /> <br/> --%>

	<br/><br/>
	Search Admins with Ajax: 
	<input type="text" id="ajaxText" />
	<input type="submit" id="ajaxSearch" value="Asynchron search" />
	<div id="ajaxResult"></div>
	
	<br/>
	
	<br/><br/>
	
	<sf:form action="${pageContext.request.contextPath}/admin/save" method="post" commandName="admin">
		
	
	<table>
<!-- 		<input name="estado" type="text"> -->
		<c:if test="${admin.idAdmin ne 0}">
			<sf:input path="idAdmin" type="hidden" />
			<sf:input path="creationDate" type="hidden" />
		</c:if>
		<tr>
			<td>Name</td>
			<td><sf:input path="name" type="text" /></td>
		</tr>
		<tr>
			<td>Role</td>
			<td><sf:input path="role" type="text" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save Changes"> </td>
		</tr>
		
	</table>
	
	</sf:form>
	<br/>
	<h3><c:out value="${rdo}"></c:out></h3> <br/><br/>
	
	<c:forEach items="${admins}" var="admin">
		
		<a href='<c:url value="/address/${admin.idAdmin}" />'>Show Address</a>&nbsp;
		<a href='<c:url value="/admin/${admin.idAdmin}/update" />'>Update</a>
		<c:out value="${admin}" /> 
		<a class="confirm" href='<c:url value="/admin/${admin.idAdmin}/delete" />'>Delete</a>
		<br/>
	</c:forEach>
</body>
</html>