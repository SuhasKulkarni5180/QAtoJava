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
	
	<h3>New account created Successfully</h3>
	<h4> Customer ID :</h4>${newaccount.cusid}
	<h4> Account Number :</h4>${newaccount.accountNumber}
	<h4> Account Type :</h4>${newaccount.accountType}
	<h4> Balance :</h4>${newaccount.balance}
					
	

</body>

</html>









