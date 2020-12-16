<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<title>Navigations</title>

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
	
	<h3>Navigations</h3>
	
		<div id="content">
		
			<!--  add our html table here -->
		
		
			<table>
				<tr>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				
				<!-- loop over and print our customers -->
				
					<c:url var="balanceCheck" value="/api/balanceaccountinput">
					</c:url>
					
					<c:url var="miniStatement" value="/api/mini">
					</c:url>
					
					
					<c:url var="monthlyStatement" value="/api/selectMonth">
					</c:url>
					
					<c:url var="annualStatement" value="/api/selectYear">
					</c:url>
					
					
					<c:url var="createAccount" value="/api/createAccount">
					</c:url>
					
					<c:url var="createTrasaction" value="/api/createTrans">
					</c:url>
					
						<tr><td> <a href="${createAccount}"> Create Account </a></td></tr>
						<tr><td> <a href="${balanceCheck}"> Balance Check </a></td></tr>
						<tr><td> <a href="${miniStatement}"> Mini Statement </a></td></tr>
						<tr><td> <a href="${monthlyStatement}"> Monthly Statement </a></td></tr>
						<tr><td> <a href="${annualStatement}">  Annual Statement </a></td></tr>
						<tr><td> <a href="${createTrasaction}"> Create Transaction </a></td></tr>
						<tr><td> <a href="${payBills}"> Pay Bills </a></td></tr>
						<tr><td> <a href="${applyForLoans}"> Apply for Loan </a></td></tr>
						<tr><td> <a href="${transferFunds}"> Transfer Fund </a></td></tr>

			</table>
				
		</div>
	
	</div>

</body>

</html>










