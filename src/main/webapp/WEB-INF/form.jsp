<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/form/new" method="POST">
<h3>Meal at <c:out value="${sessionScope.check.restaurant }"/> with ${sessionScope.check.partySize} guests</h3> 
<c:forEach var="i" begin ="1" end="${sessionScope.check.partySize}">
<p>
<label>Name</label>
<input type="text" name="guest">
<label>Phone Number</label>
<input type="text" name="phone">
</c:forEach>
<input type="submit">
</form>
</body>

</html>