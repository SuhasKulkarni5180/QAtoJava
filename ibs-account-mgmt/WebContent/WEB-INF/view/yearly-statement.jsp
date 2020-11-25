<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Yearly Statement</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>IBS - Integrated Banking System</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Yearly Statement </h3>
		<div id="content">
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Transaction ID</th>
					<th>Customer ID</th>
					<th>Create Date</th>
					<th>Transaction Type</th>
					<th>Amount</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="trans" items="${yearlyStatement}">
							
					<tr>
						<td> ${trans.id}</td>
						<td> ${trans.custId} </td>
						<td> ${trans.createDate} </td>
						<td> ${trans.transType} </td>
						<td> ${trans.amount} </td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









