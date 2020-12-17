<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Yearly Statement</title>

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
		<h3>Yearly Statement</h3>
	
		<form:form action="yearly" method="GET">
		
			<table>
				<tbody>
				
				<tr>
					<td>Account Number :</td><td><input type="text" name="accountnumber"></td>
				</tr>
									
					<tr>
					
						<td><label>Select Year:</label></td>
						<td><select name="year">
						    <option value="2020">2020</option>
						    <option value="2019">2019</option>
						    <option value="2018">2018</option>
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










