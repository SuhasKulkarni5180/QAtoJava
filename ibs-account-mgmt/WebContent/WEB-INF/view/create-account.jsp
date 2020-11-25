<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Create Account</title>

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
		<h3>Create Account</h3>
	
		<form:form action="createAccount" modelAttribute="account" method="POST">
		
			<table>
				<tbody>
					
					<tr>
						<td><label>Customer Id:</label></td>
						<td> 100 </td>
					</tr>
					
					<tr>
					
						<td><label>Account Type:</label></td>
						<td><select name="accountType">
						    <option value="Savings Bank">Savings Bank</option>
						    <option value="Recurring Deposit">Recurring Deposit</option>
						    <option value="Fixed Deposit">Fixed Deposit</option>
							</select>
						</td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
	
	</div>

</body>

</html>










