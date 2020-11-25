<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Transaction Creation</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>IBS - Integrated Banking System</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Transaction Creation</h3>
	
		<div id="content">

			<!--  add our html table here -->
		<form:form action="createTrans" modelAttribute="transaction" method="POST">
			<table>
				<tbody>
					
					<tr>
						<td><label>Customer Id:</label></td>
						<td>100</td>
					</tr>
					<tr>
					
						<td><label>Pay Bill Type:</label></td>
						<td><select name="paybill">
						    <option value="electric bill">Electric bill</option>
						    <option value="water bill">Water Bill</option>
						    <option value="gas bill">Gas Bill</option>
						    <option value="Broadband bill">Broadband Bill</option>
						    <option value="Telephone bill">Telephone Bill</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td><label>Amount:</label></td>
						<td><input name= 'amount' type = 'text'></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Pay" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		</form:form>
		</div>
	
	</div>
	

</body>

</html>
