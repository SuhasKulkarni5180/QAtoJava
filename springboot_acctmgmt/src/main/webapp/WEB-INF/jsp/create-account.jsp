<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Create Account</title>

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
		<h3>Create Account</h3>
	
		<form:form action="newAccount" modelAttribute="account" method="GET">
		
			<table>
				<tbody>
					<tr>
					
					</tr>

					
					<tr>
					
						<td><label>Account Type:</label></td>
						<td><select name="accountType">
						    <option value="Savings Account">Savings Account</option>
						    <option value="Recurring Deposit">Recurring Deposit</option>
						    <option value="Fixed Deposit">Fixed Deposit</option>
							</select>
						</td>
					</tr>
					<tr>
					<td>Initial Deposit :</td><td><input type ="text" name="amount"/></td>
					</tr>	
					<tr>
					<tr>
					<td>Customer Id :</td><td><input type ="text" name="cusid"/></td>
					</tr>	
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Submit" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
	
	</div>

</body>

</html>










