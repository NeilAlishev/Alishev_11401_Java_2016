<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta fullName="viewport" content="width=device-width, initial-scale=1">
    <meta fullName="description" content="mySite">
    <meta fullName="author" content="Neil">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" type="text/css"/>
    <link href="/static/css/sb-admin.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/plugins/morris.css" rel="stylesheet" type="text/css"/>
    <link href="/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/custom.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="/static/css/select2/select2.min.css" type="text/css"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <title>
        Моя статистика
    </title>
    <script type="text/javascript" src="/static/js/loader.js"></script>
</head>
<body>
<div id="wrapper">
    <div id="page-wrapper">
        <div class="container-fluid">
        <#include "../navigation.ftl">
            <div class="row">
                <div class="col-lg-12">
                    <h2 style="text-align: center;">Моя статистика</h2>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i>Статистика оценок</h3>
                        </div>
                        <div id="chart_div"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/static/js/jquery-2.1.4.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script>
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawCurveTypes);

    var marks;
    $.get("/marks/getMarksJSON", function (data) {
                marks = data;
            }
    );
    function drawCurveTypes() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'X');
        data.addColumn('number', 'Средний балл за день');
        var marksMap = new Map();
        marks.forEach(function (mark) {
            if (marksMap.has(mark.date)) {
                marksMap.get(mark.date).push(mark.score);
            } else {
                marksMap.set(mark.date, []);
                marksMap.get(mark.date).push(mark.score);
            }
        });
        for (var key of marksMap.keys()) {
            marksMap.set(key, (marksMap.get(key).reduce(function (a, b) {
                        return a + b;
                    })) / marksMap.get(key).length
            );
        }
        var statistics = [];

        for (key of marksMap.keys()) {
            var currentArray = [];
            currentArray.push(key, marksMap.get(key));
            statistics.push(currentArray);
        }

        data.addRows(statistics);

        var options = {
            hAxis: {
                title: 'Даты'
            },
            vAxis: {
                title: 'Оценки'
            },
            series: {
                1: {curveType: 'function'}
            }
        };

        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }
</script>
</body>
</html>