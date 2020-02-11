<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link href="/css/style.css" rel="stylesheet">
    <script src="/js/main.js"></script>
</head>
<body>
<form:form action="/checks/new" method="POST" modelAttribute="check">
	<h2>Enter your check information</h2>
		<p>
			<form:label path="restaurant">Restaurant Name</form:label>
			<form:input path="restaurant"/>
		</p>
		<p>
			<form:label path="subtotal">Subtotal:</form:label>
			<form:input path="subtotal"/>
		</p>
		<p>
			<form:label path="taxAmount">Tax Amount:</form:label>
			<form:input path="taxAmount"/>
		</p>
		<p>
			<form:label path="partySize">Size of Party:</form:label>
			<form:input path="partySize"/>
		</p>
		<p>
			<form:label path="city">City:</form:label>
			<form:input path="city"/>
		</p>
	<input type=submit value="Submit">
</form:form>



</body>

</html>