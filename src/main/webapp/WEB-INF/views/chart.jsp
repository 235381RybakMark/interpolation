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
    background: #c7b39b url(images/oil.jpg) center no-repeat fixed; background-size: 100%; 
    color: #fff; 
   }
  </style>

<script type="text/javascript">
	window.onload = function() {
		
		var dps = [ [] ];
		var chart = new CanvasJS.Chart("chartContainer", {
			theme : "light2", // "light1", "dark1", "dark2"
			animationEnabled : true,
			title : {
				text : "Interpolacja wielomianowa - Metoda Lagrangea"
			},
			subtitles : [ {
				text : "Zapotrzebowanie ropy naftowej w swiecie"
			} ],
			axisX : {
				valueFormatString : "####"
			},
			axisY : {
				title : "million barrels"
			},
			data : [ {
				type : "spline",
				xValueFormatString : "####",
				yValueFormatString : "#,##0.0 million barrels",
				dataPoints : dps[0]
			} ]
		});

		var xValue;
		var yValue;

		<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
		<c:forEach items="${dataPoints}" var="dataPoint">
		xValue = parseInt("${dataPoint.x}");
		yValue = parseFloat("${dataPoint.y}");
		dps[parseInt("${loop.index}")].push({
			x : xValue,
			y : yValue
		});
		</c:forEach>
		</c:forEach>

		if("${displayChart}" == "true"){
			chart.render();
		}
		

	}
</script>

</head>

<body>

	<form class=mysubform action="#"id="uniqueValue-123" action="canvasjschart" method="post">

<script>
function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57)) return false;
       return true;
    };
</script>

		<br />
		<label>From:</label> 	
		<input type="text" name="from" autofocus maxlength="4" onkeypress="return isNumberKey(event)" placeholder="rok rozpoczecia" required placeholder>  
		<br />
		<label>To:</label>
		<input type="text" name="to" maxlength="4" onkeypress="return isNumberKey(event)" placeholder="rok rozpoczecia" required placeholder>  
		<br />
		<label>Years:</label> 
		<input type="text" name="period" maxlength="2" onkeypress="return isNumberKey(event)" placeholder="na ile lat chcesz rozliczyc" required placeholder >
		<br /> 
		<input type="submit" class="submitbtn" value="Policz">
		 <br />
		  <br />
</form>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
