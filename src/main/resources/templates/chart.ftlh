<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script type="text/javascript">
        window.onload = function() {

            var dps = [[], [], [], []];
            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2",
                title: {
                    text: "График нагрузки"
                },
                legend: {
                    verticalAlign: "center",
                    horizontalAlign: "right"
                },
                axisX: {
                    viewportMinimum: 0,
                    viewportMaximum: 24,
                    title: "Час нагрузки"
                },
                axisY: {
                    title: "Температура, °C",
                    includeZero: true
                },
                data: [{
                        type: "line",
                        lineColor:"red",
                        markerColor: "red",
                        showInLegend: true,
                        legendText: "температура масла",
                        dataPoints: dps[0]},
                    {
                        type: "line",
                        lineColor:"blue",
                        markerColor: "blue",
                        showInLegend: true,
                        legendText: "температура ннт",
                        dataPoints: dps[1]},
                    {
                        type: "line",
                        lineColor:"red",
                        markerColor: "red",
                        markerType: "cross",
                        showInLegend: true,
                        legendText: "макс температура масла",
                        dataPoints: dps[2]},
                    {
                        type: "line",
                        lineColor:"blue",
                        markerColor: "blue",
                        markerType: "cross",
                        showInLegend: true,
                        legendText: "макс температура ннт",
                        dataPoints: dps[3]}
                ]
            });

            var xValue;
            var yValue;

            <#list dataPointsList as dataPoints>
                <#list dataPoints as dataPoint>
                    xValue = parseInt("${dataPoint.x}");
                    yValue = parseFloat("${dataPoint.y}");
                    dps[parseInt("${dataPoints?index}")].push({x : xValue, y : yValue});
                </#list>
            </#list>

            chart.render();

        }
    </script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>