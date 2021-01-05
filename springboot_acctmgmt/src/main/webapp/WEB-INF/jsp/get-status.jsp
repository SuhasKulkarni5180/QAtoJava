<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Balance Summary</title>
	
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
		<h3>Balance Summary</h3>
	
		<div id="content">
		
		<a href="showExecutiveMenu"> Home </a>
		<br/><br/>
		

			<!--  add our html table here -->
		<form action="applicationstatus" method="Get">
			<table>
			
				<tr>
				<td>Application Number :</td><td><input type="text" name="appid" /></td>
				
				</tr>
				
				<tr>
				<td><td><input type="submit" name="Submit" /></td></td>
				</tr>
				
				
				<tr>
					<th>Application Id</th> 
					<th>First Name</th>
					<th>Identity</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Status</th>
				</tr>
				<tr>
					<td>${status.appId} </td>
					<td>${status.firstname}</td>
					<td>${status.identity}</td>
					<td>${status.phone}</td>
					<td>${status.email}</td>
					<td>${status.status}</td>
				
				</tr>
				
				
			</table>
			</form>	
		</div>
	
	</div>
	

</body>

</html>
