$(document).ready(function() {
	var max_fields      = 10; //maximum input boxes allowed
	var wrapper   		= $(".input_fields_wrap"); //Fields wrapper
	var add_button      = $(".add_field_button"); //Add button ID
	
	var x = 1; //initlal text box count
	$(add_button).click(function(e){ //on add input button click
		e.preventDefault();
		if(x < max_fields){ //max input box allowed
			x++; //text box increment
			$(wrapper).append('<div><p><label>Item ordered:</label><input type="text" name="name"/></p><p><label>Subtotal (Before tax & tip):</label><input type="text" name="price"/></p></div>'); //add input box
		}
	});
	
});