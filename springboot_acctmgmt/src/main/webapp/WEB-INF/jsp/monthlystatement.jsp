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

<table>

				<core:forEach var="model" items="${customeroutput}">
							
					<tr>
						<td>Cust ID: ${model.cusid}</td>
						<td>Transaction type: ${model.transType} </td>
						<td>Amount: ${model.amount} </td>
						<td>Create Date: ${model.createDate} </td>
						
					</tr>
				
				</core:forEach>

</table>
					

</body>
</html>










