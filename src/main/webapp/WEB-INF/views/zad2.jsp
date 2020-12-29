<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	window.onload = function() {		
		var result = document.getElementById('resultData');
		result.style.display = 'none';

		if("${displayResult}" == "true"){
			result.style.display = 'block';
		}
		

	}
</script>
</head>

<body>

	<form id="uniqueValue-124" action="zad2" method="post" name="myForm2">
		<br/>
		<label>Enter precision:</label> 	
		<input type="text" id="from2" name="from2">  
		<br/> 
		<input type="submit" value="Calculate">		  
	</form>
	
	<div id="resultData">
	Approximate solution of the equation: <b>${key}</b>
	<br/>
	Number of steps: <b>${value}</b>
	</div>
</body>
</html>
