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
		
		<a href="showMenu"> Home </a>
		<br/><br/>
		

			<!--  add our html table here -->
		<form action="balance" method="Get">
			<table>
			
				<tr>
				<td>Account number :</td><td><input type="text" name="accountnumber" /></td>
				
				</tr>
				
				<tr>
				<td><td><input type="submit" name="Submit" /></td></td>
				</tr>
				
				
				<tr>
					<th>Account Type :  ${customeroutput.accountType} </th> 
					<th>Balance : ${customeroutput.balance} </th>
				</tr>
				
				
		
						
			</table>
			</form>	
		</div>
	
	</div>
	

</body>

</html>
