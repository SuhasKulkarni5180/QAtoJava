<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Monthly Statement</title>


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
		<h3>Monthly Statement</h3>
	
		<form:form action="monthly" method="GET">
		
			<table>
				<tbody>
				<tr>
					<td>Account Number :</td><td><input type="text" name="accountnumber"></td>
				</tr>
									
					<tr>
					
						<td><label>Select Month:</label></td>
						<td><select name="month">
							<option value="01">January</option>
						    <option value="02">February</option>
						    <option value="03">March</option>
						    <option value="04">April</option>
						    <option value="05">May</option>
						    <option value="06">June</option>
						    <option value="07">July</option>
						    <option value="08">August</option>
						    <option value="09">September</option>
						    <option value="10">October</option>
						    <option value="11">November</option>
						    <option value="12">December</option>
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










