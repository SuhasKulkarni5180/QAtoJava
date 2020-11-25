<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Mini Statement</title>
	
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
		<h3>Mini Statement </h3>
		<div id="content">
		<h6>Last Five Trasactions </h6>
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
				<c:forEach var="trans" items="${miniStatement}">
							
					<tr>
						<td> ${trans.id} </a></td>
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









