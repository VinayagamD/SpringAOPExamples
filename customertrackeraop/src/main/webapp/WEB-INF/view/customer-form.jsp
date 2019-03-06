<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Save Customer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
	
	
</head>
</head>
<body>
	<div id="wrapper">
	 	 <div id="header">
	 	 	<h2>CRM - Customer Relationship Manager</h2>
	 	 </div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			<!-- need to associate this data with customer id -->
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>FirstName:</label></td>
						<td><form:input path="firstName"/> 	 </td>
					</tr>
					<tr>
						<td><label>LastName:</label></td>
						<td><form:input path="lastName"/> 	 </td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"/> 	 </td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save">	 </td>
					</tr>
				
				</tbody>
			</table>
		</form:form>
		
		<div style="clear;  both;">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
			</p>
		</div>
	</div>
</body>
</html>