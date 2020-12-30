<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <style><%@include file="/WEB-INF/Css/Csschart.css"%></style>
<style>
   body {
    background: #c7b39b url(images/ug.jpg) center no-repeat fixed; background-size: 100%; 
    color: #fff; 
   }
  </style>
<body>
<script type="text/javascript">

function clearBoxFrom(){
    var textboxFrom = document.getElementById("from2").value = '';

}

function validateForm() {
 	  var g = document.forms["myForm2"]["from2"].value;
 	  
 	  if (g <= 0) {
 	    var textbox = document.getElementById("from2");
 	    textbox.value = "Min value is > 0";    	    
 	    return false;
 	  }
 	  if (g >= 1) {
   	    var textbox = document.getElementById("from2");
   	    textbox.value = "Max value is < 1";    	    
   	    return false;
   	  }
 	  
 }

	window.onload = function() {		
		var result = document.getElementById('resultData');
		result.style.display = 'none';
		
		

		if("${displayResult}" == "true"){
			result.style.display = 'block';
		}
		

	}
   
</script>
</head>

	<form class=mysubform id="uniqueValue-124" action="zad2" method="post" name="myForm2" onsubmit="return validateForm()">
		<br/>
		<label>Enter precision:</label> 	
			<input type="text" step="any" id="from2" name="from2" onclick="clearBoxFrom()" onkeypress="return isNumberKey(event)" placeholder="Precision must be ranged in (0,1)" required placeholder>  
			<br/> 
		<input type="submit" value="Calculate">		  
	</form>
	
	<div id="resultData">
	Approximate solution of the equation: <b>${key}</b>
	<br/>
	Number of steps: <b>${value}</b>
	</div>
	
	<img src="/images/zadanie2.jpg" class="img" />
	
</body>
</html>