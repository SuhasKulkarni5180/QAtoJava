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
			
			<a href="showExecutiveMenu"> Home </a>
			<br/><br/><br/>
			<table>
				<tr>
					<th>Application ID</th>
					<th>First Name</th>
					<th>Identity</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Status</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="model" items="${unapproved}">
							
					<tr>
						<td>${model.appId}</td>
						<td>${model.firstname}</td>
						<td>${model.identity} </td>
						<td>${model.phone} </td>
						<td>${model.email} </td>
						<td>${model.status}</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









