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
		<div class="topnav-right">
				<a href="login"> Logout </a>
				<br/><br/>
		</div>
			<table>
				<tr>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				
				<!-- loop over and print our customers -->
				
					<c:url var="getAppStatus" value="/api/getAppStatus">
					</c:url>
					
					<c:url var="getUnapproved" value="/api/getUnapproved">
					</c:url>
					
					
					<c:url var="getApproved" value="/api/getApproved">
					</c:url>
										
						<tr><td> <a href="${getAppStatus}"> Get Application status </a></td></tr>
						<tr><td> <a href="${getUnapproved}"> Unapproved Applications </a></td></tr>
						<tr><td> <a href="${getApproved}"> Approved Applications </a></td></tr>


			</table>
				
		</div>
	
	</div>

</body>

</html>










