<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body background="<c:url value="/resources/images/lighthous.png/" />">

	
    <form:form action="here/register" method="post" modelAttribute="user">
    </br></br></br></br></br></br></br></br></br></br></br></br>
		<table align="center">
			<tr>
				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>

				<td><form:input path="id" pattern=".{4,7}" required="true"
						title="id should contains 4 to 7 characters" /></td>
			</tr>
			<tr>
				<td><form:label path="name">
						<spring:message text="User Name" />
					</form:label></td>

				<td><form:input path="name" required="true"
						title="name should not be empty" /></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message text="Password" />
					</form:label></td>

				<td><form:input path="password" pattern=".{4,15}"
						required="true"
						title="password should contains 4 to 15 characters" /></td>
			</tr>
			<tr>
				<td><form:label path="contactnumber">
						<spring:message text="Mobile" />
					</form:label></td>

				<td><form:input type="tel" path="contactnumber" pattern="^\d{10}$" required="true"
						title="Please enter valid mobile number" /></td>
			</tr>

			<tr>
				<td><form:label path="mailid">
						<spring:message text="Email" />
					</form:label></td>

				<td><form:input type="email" path="mailid" /></td>
			</tr>

			<tr>
				<td><form:label path="address">
						<spring:message text="Address" />
					</form:label></td>

				<td><form:input path="address" required="true" /></td>
			</tr>

			<tr>

				<td><input type="submit"
					value="<spring:message text="Register"/>" /></td>
				<td><input type="reset" value="<spring:message text="Reset"/>" />
				</td>
			</tr>

		</table>

	</form:form>

	

</body>
</html>