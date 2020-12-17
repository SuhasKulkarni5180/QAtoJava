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
	
	<h3>Login</h3>
	
	
	<form action="user" method="POST">
		
	<table>
	
		<tr>
		<td>User Name : <input type="text" name=userName />	</td>	
		</tr>		
		<tr>
		<td>Password :  <input type="text" name="pwd" /></td>
		</tr>			
		
		<tr>
			<td><input type="submit" name="Submit" />	</td>
		</tr>
		<tr>
		<td> Not registered <a href="register">click here</a></td>
		</tr>
	
	</table>	
	 
	</form>
	
	</div>


</body>

</html>










