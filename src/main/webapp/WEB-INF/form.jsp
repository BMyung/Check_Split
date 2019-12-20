<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<head>
	<link href="/css/style.css" rel="stylesheet">
    <script src="/js/main.js"></script>
</head>

</head>
<body>
<h3>Meal at <c:out value="${sessionScope.check.restaurant }"/> with ${sessionScope.check.partySize} guests</h3> 

<!-- The text field -->
<input type="text" value="http://localhost:8080/${sessionScope.check.code}/orderform" id="myInput">

<!-- The button used to copy the text -->
<button onclick="myFunction()">Copy text</button>
</body>
</html>