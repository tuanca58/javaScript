/**
 * 
 */
function validPhone() { 
	var phNum = document.form_name.1.value + document.form_name.2.value + document.form_name.3.value; 
	// Check for numbers only 
	for (i = 0; i < phNum.length; i++) { 
		if (phNum.charAt(i) < "0" || phNum.charAt(i) > "9") { 
			alert("Please enter only numbers.");
			return false; 
			} 
		}		
	// Check for 10 digits
	if (phNum.length < 10) {
		alert("Please enter your 10-digit phone number."); 
		return false; 
	}
	return true;
}