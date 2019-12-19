<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>

<body>
<h2></h2>
<form:form method="POST" action="/orderform/process" modelAttribute="item">
	<c:forEach var="i" begin="1" end="${sessionScope.orderItemCount}">
		<p>
			<form:label path="name">Item ordered:</form:label>
			<form:input path="name"/>
		</p><form:errors path="name" class="red" />
		<p>
			<form:label path="price">Subtotal (Before tax & tip):</form:label>
			<form:input path="price"/>
		</p><form:errors path="price" class="red" />
		
		
		<hr>
	</c:forEach>
		
		<input type="submit">
</form:form>

</body>

</html>