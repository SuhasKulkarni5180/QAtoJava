<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Login</title>
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
	
	<h3>New Registration</h3>
	
	
	<form action="registrationform" method="get">
		
	<table>
	
		<tr>
			<td>First Name :<input type="text" name=firstName />	</td>
		</tr>
		
		
		<tr>
			<td>Last Name : <input type="text" name="lastName" /></td>
		</tr>
		
		<tr>
			<td>Middle Name :<input type="text" name=middleName />	</td>
		</tr>
		
		<tr>
			<td>Email :<input type="text" name=email />	</td>
		</tr>
		
		<tr>
			<td>Phone :<input type="text" name=phone />	</td>
		</tr>			

		<tr>
			<td><input type="submit" name="Submit" />	</td>
		</tr>
		
	</table>	
	 
	</form>
	
	</div>

</body>

</html>










