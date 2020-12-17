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
	
	<h3>New account created Successfully</h3>
	<h5> Customer ID :</h5>${newaccount.cusid}
	<h5> Account Number :</h5>${newaccount.accountNumber}
	<h5> Account Type :</h5>${newaccount.accountType}
	<h5> Balance :</h5>${newaccount.balance}
					
	

</body>

</html>









