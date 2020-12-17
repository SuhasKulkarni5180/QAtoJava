<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Mini Statement</title>
	
	<!-- reference our style sheet -->
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
		<h3>Mini Statement </h3>
		<div id="content">
			<!--  add our html table here -->
			
			<a href="showMenu"> Home </a>
			<br/><br/><br/>
			<table>
				<tr>
					<th>Transaction ID</th>
					<th>Customer ID</th>
					<th>Create Date</th>
					<th>Transaction Type</th>
					<th>Amount</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="model" items="${mini}">
							
					<tr>
						<td>${model.id}</td>
						<td>${model.cusid}</td>
						<td>${model.date} </td>
						<td>${model.transType} </td>
						<td>${model.amount}</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









