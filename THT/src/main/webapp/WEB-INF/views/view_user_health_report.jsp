<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>The Healthy Table - Home</title>
<link rel="stylesheet" href="/tht/resources/blueprint/screen.css" type="text/css" media="screen, projection">
<link rel="stylesheet" href="/tht/resources/blueprint/print.css" type="text/css" media="print">
<link href="<c:url value="/resources/style/nav_bar.css" />" rel="stylesheet"  type="text/css" />
<link href="<c:url value="/resources/style/utl.css" />" rel="stylesheet"  type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/scripts/nav_bar.js" />"></script>
   <script type="text/javascript"
          src="https://www.google.com/jsapi?autoload={
            'modules':[{
              'name':'visualization',
              'version':'1',
              'packages':['corechart']
            }]
          }"></script>

    <script type="text/javascript">
      google.setOnLoadCallback(drawChart);

      function drawChart() {
        var dates = JSON.parse("[" + '${dates}' + "]");
        var calories = JSON.parse("[" + '${calories}' + "]");
      	var data = new google.visualization.DataTable();
      	data.addColumn('string', 'Date');
      	data.addColumn('number', 'Calorie');
		for(var i=0;i<dates.length;i++){
			data.addRow([dates[i],Number(calories[i])]);
		}

        var options = {
          title: 'Health Trace',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
</head>
<body onload="setSearchBoxWidth();" onresize="setSearchBoxWidth();">
	<div id="page_1">
		<%@ include file="nav_bar.jsp"%>
		<div id="content_1">
			<div style="font-size: 18px; color: red; margin-top: 20px; margin-bottom: 20px;">
				Total Consumed Calorie: ${healthReport.totalConsumedCalorie}<br>
				Total Unconsumed Calorie: ${healthReport.totalUncomsumedCalorie}<br>
				Today Consumed Calorie: ${healthReport.todayConsumedCalorie}<br>
			</div>
		</div>
		<div id="curve_chart" style="width: 900px; height: 500px; margin-left: 300px;"></div>
	</body>
</html>

