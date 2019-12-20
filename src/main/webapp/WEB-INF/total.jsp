<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<link href="/css/style.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="/js/main.js"></script>
    
    
    <script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
    function crunchifyAjax() {
        $.ajax({
            url : '/ajaxtest/${check.code}',
            success : function(data) {
                $('#result').html(data);
            }
        });
    }
</script>
 
<script type="text/javascript">
    var intervalId = 0;
    intervalId = setInterval(crunchifyAjax, 2000);
</script>
</head>

<body>
<h2>Meal at <c:out value="${check.restaurant }"/> with ${check.partySize} guests</h2>
<c:if test="${order !=null}">
<h2>Your total bill for ${order.name} is</h2>
<fmt:setLocale value = "en_US"/>
Subtotal: <fmt:formatNumber value = "${order.subtotal}" type = "currency"/><br>
Tax Amount: <fmt:formatNumber value = "${order.tax}" type = "currency"/><br>
Tip Amount: <fmt:formatNumber value = "${order.tip}" type = "currency"/><br>
___________________________
<br>
Your total amount: <fmt:formatNumber value = "${order.total}" type = "currency"/>
</c:if>


<h3>The check total so far is <fmt:formatNumber value = "${check.total}" type = "currency"/></h3> 
<div id="changeText"></div>
 	<ul>
        <div id="result"></div>
    </ul>

<!-- The text field -->
Copy this link and send to your group see an updated total on this page.
<div>
<input type="text" value="http://localhost:8080/${check.code}/orderform" id="myInput">
<!-- The button used to copy the text -->
<button onclick="myFunction()">Copy text</button>
</div>
</body>
</html>