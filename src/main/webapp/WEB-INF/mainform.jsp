<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="/js/ordercount.js"></script>
</head>

<body>
<h2></h2>
<form method="POST" action="/orderform/${code}/process">
	<div class="input_fields_wrap">
	<div>
    	<p>
			<label>Item ordered:</label>
			<input type="text" name="name"/>
		</p>
		<p>
			<label>Subtotal (Before tax & tip):</label>
			<input type="text" name="price"/>
		</p>
</div>
</div>
    <button class="add_field_button">Add another item</button>
    <br>
    <br>
 <input type="radio" name="tipPercent" value=0> None<br>
 <input type="radio" name="tipPercent" value=.15> 15%<br>
<input type="radio" name="tipPercent" value=.18> 18%<br>
<input type="radio" name="tipPercent" value="other"> Other
<input type="text" name="tipPercent">
    <br>
    <br>
    
		<input type="submit">
</form>

</body>

</html>