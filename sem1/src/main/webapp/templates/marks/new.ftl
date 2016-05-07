<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta fullName="viewport" content="width=device-width, initial-scale=1">
    <meta fullName="description" content="mySite">
    <meta fullName="author" content="Neil">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" type="text/css"/>
    <link href="/static/css/custom.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/static/css/select2/select2.min.css" type="text/css"/>
    <link rel="stylesheet" href="/static/css/jquery-ui.min.css" type="text/css"/>
    <link rel="stylesheet" href="/static/css/jquery-ui.structure.min.css" type="text/css"/>
    <link rel="stylesheet" href="/static/css/jquery-ui.theme.min.css" type="text/css"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="/static/js/jquery-2.1.4.min.js"></script>
    <script src="/static/js/jquery-ui.min.js"></script>
    <title>Оценки</title>
    <script>
        $(function () {
            $("#datepicker").datepicker({dateFormat: 'dd-mm-yy'});
        });
    </script>
</head>
<body>
<#if info??>
<div class="alert alert-success" role="alert" style="text-align: center;">
${info}
</div>
</#if>
<#if error??>
<div class="alert alert-danger" role="alert" style="text-align: center;">
${error}
</div>
</#if>
<a href="/" style="float:left; margin-left: 20pt;"><h4>Обратно</h4></a>
<div class="forms" style="text-align: center;">
    <h1 style="text-align: center">Поставить оценку</h1>
    <form action="/marks/create" method="POST">
        <div class="field">
            <h4>Имя студента</h4>
            <select name="student" class="js-example-basic-single js-states form-control" id="group-select">
            <#list groups as group>
                <#list group.students as student>
                    <option value="${student.id}" title="${student.group.name}">${student.fullName}</option>
                </#list>
            </#list>
            </select>
        </div>
        <h4>Предмет</h4>
        <div class="field">
            <input type="text" name="subject" placeholder="Предмет" class="form-control"/>
        </div>
        <h4>Оценка</h4>
        <div class="field">
            <select name="score" class="js-example-basic-single js-states form-control" id="mark-select">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
        </div>
        <h4>Дата</h4>
        <div class="field">
            <input type="text" name="date" id="datepicker" class="form-control" style="text-align: center;"/>
        </div>
        <div class="actions" style="margin-top:30px;">
            <input type="submit" value="Поставить оценку" class="btn btn-md btn-block"/>
        </div>
    </form>
</div>
<script src="/static/js/select2/select2.full.min.js"></script>
<script src="/static/js/select2/ru.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $.fn.select2.defaults.set('language', 'ru');
        $("#group-select").select2({
            placeholder: {
                text: 'Select an option'
            }
        });
        $("#mark-select").select2({
            minimumResultsForSearch: -1
        });
    });
</script>
</body>
</html>