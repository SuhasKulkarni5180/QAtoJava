<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Balance Summary</title>
	
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
		<h3>Balance Summary</h3>
	
		<div id="content">

			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Account Type</th>
					<th>Balance</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="balan" items="${balance}">
					<tr>
						<td> ${balan.accountType} </td>
						<td> ${balan.balance} </td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>
