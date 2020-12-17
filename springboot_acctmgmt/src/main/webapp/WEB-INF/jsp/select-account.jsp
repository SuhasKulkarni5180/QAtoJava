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
		<h3>Account</h3>
	
		<form:form action="ministatement" method="GET">
		
			<table>
				<tbody>
									
					<tr>
					
			
						<td>Account Number : <input type ="text" name = "accountnumber"></td>
						
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










