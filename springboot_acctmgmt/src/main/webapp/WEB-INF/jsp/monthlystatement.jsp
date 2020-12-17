<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/css/style.css"/>
	
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/css/add-customer-style.css"/>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>IBS - Integrated Banking System</h2>
		</div>
	</div>

	<div id="container">
		<h3>Monthly Statement</h3>
		</div>

<hr/>

		<a href="showMenu"> Home </a>
		<br/><br/>

<table>
				<tr>
					<th>Cust ID</th>
					<th>Transaction type</th>
					<th>Amount</th>
					<th>Create Date</th>
				</tr>
				
				
				
				
				<core:forEach var="model" items="${customeroutput}">
							
					<tr>
						<td>${model.cusid}</td>
						<td>${model.transType} </td>
						<td>${model.amount} </td>
						<td>${model.date} </td>
						
					</tr>
				
				</core:forEach>

</table>
					

</body>
</html>










