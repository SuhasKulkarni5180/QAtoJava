<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<title>Navigations</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
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
				
					<c:url var="balanceCheck" value="/customer/checkBalance">
					</c:url>
					
					<c:url var="miniStatement" value="/customer/miniStatement">
					</c:url>
					
					<c:url var="monthlyStatement" value="/customer/selectMonth">
					</c:url>
					
					<c:url var="annualStatement" value="/customer/selectYear">
					</c:url>
					
					<c:url var="createTrasaction" value="/customer/createTrasaction">
					</c:url>

					<c:url var="payBills" value="/customer/payBills">
					</c:url>
					
					<c:url var="applyForLoans" value="/customer/applyForLoans">
					</c:url>
					
					<c:url var="transferFunds" value="/customer/transferFunds">
					</c:url>
					
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










