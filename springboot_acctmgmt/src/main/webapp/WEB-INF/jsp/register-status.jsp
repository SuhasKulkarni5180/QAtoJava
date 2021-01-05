<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Yearly Statement</title>
	
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
	<br/>	
	<a href="login"> Login </a>
	
	<h4>Your application has been submitted</h4>
	
	
	<table>
		<tr>
			<td>App ID : ${register.appId}</td>
		
		</tr>
		
		<tr>
			<td>Application Status : ${register.status}</td>
		
		</tr>
	
	
	</table>


</body>

</html>









