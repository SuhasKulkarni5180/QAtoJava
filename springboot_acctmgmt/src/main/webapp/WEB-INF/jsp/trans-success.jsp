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
	<a href="showMenu"> Home </a>
	<br/><br/><br/>
	
	<h3>User registration Success full</h3>
	<h4> Customer ID :</h4>${trans.id}
	<h4> Customer ID :</h4>${trans.cusid}
	<h4> Customer ID :</h4>${trans.acctNumber}
	<h4> Customer ID :</h4>${trans.amount}
					
	

</body>

</html>









