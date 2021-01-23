<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <style><%@include file="/WEB-INF/Css/Csschart.css"%></style>
<style>
   body {
   background: #c7b39b url(images/zad3Pic.jpeg) center no-repeat fixed; background-size: 100%; 
    color: #fff; 
   }
  </style>
<body>
<script type="text/javascript">

function clearBoxFrom(){
    var textboxFrom = document.getElementById("from2").value = '';

}

function isNumeric(n) {
	  return !isNaN(parseFloat(n)) && isFinite(n);
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
 	  
 	  if(isNumeric(g)){
 		 console.log(g); 
 	  }else{
 	   	    var textbox = document.getElementById("from2");
 	   	    textbox.value = "Not a number";    	    
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

<form action = "zad3" method = "post" modelAttribute="zadThreeObject" name="myForm" onsubmit="return validateForm()">
<script>
    function validateForm() {
    	  var x = document.forms["myForm"]["one"].value;
    	  var y = document.forms["myForm"]["two"].value;
    	  
    	  if (x < 1) {
    	    var textbox = document.getElementById("one");
    	    textbox.value = "Value must be greater or equals 1";    	    
    	    return false;
    	  }
    	  
    }    
</script>
		<h1>Numerical Methods for Differential Problems</h1>
         Enter n: <input id="one" name="one" type = "text" name = "n">
         <br />
         Enter b: <input id="two" name="two" type = "text" name = "b" />
         <input type = "submit" value = "Submit" />
      	</form>
      		<div  id="resultData">
			Euler algorithm result: <b>${key1}; ${value1}</b>
			<br/>
			Modified Euler algorithm result: <b>${key2}; ${value2}</b>
			<br/>
			Heuna algorithm result: <b>${key3}; ${value3}</b>
			<br/>
			</div>
			
			<img src="/images/zad3Tresc.jpeg" class="img" />
			
</body>
</html>