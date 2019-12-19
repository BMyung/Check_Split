<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link href="/css/style.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="/js/main.js"></script>
</head>

<body>
Please enter the number of items ordered
<form action="/ordercount" method="POST">
<select name="orderItemCount">
<c:forEach var="i" begin="1" end="8">
<option value="${i}">${i}</option>
</c:forEach>
</select>
<input type="submit" value="submit">
</form>

<h1>1. Test CSS</h1>

<h2>2. Test JS</h2>
<div id="msg"></div>


</body>

</html>