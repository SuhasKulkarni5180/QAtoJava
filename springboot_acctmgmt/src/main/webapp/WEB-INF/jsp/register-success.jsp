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
	
	<h3>User registration Success full</h3>
	<h5> Customer ID : ${register.id}</h5>
	<h5> User Name : ${register.username}</h5>
	<h5> Password : ${register.password}</h5>
	
	
					
	

</body>

</html>









