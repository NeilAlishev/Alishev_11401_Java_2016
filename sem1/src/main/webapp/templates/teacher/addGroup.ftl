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
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <title>Добавление группы</title>
</head>
<body>
<a href="/teacher/groups" style="float:left; margin-left: 20pt;"><h4>Обратно</h4></a>
<div class="forms">
    <h1 style="text-align: center">Добавление группы</h1>
<#if error??>
    <div class="help-block" style="color: red;">
        <h3>${error}</h3>
    </div>
</#if>
    <form action="" method="POST">
        <div class="field">
            <br/>
            <h4 style="color:darkred; display: inline;">Формат: город_номерШколы_номерКласса_букваКласса</h4>
            <br/>
            <br/>
            <select name="group" class="js-example-basic-single js-states form-control" id="group-select">
            <#list groups as group>
                <option value="${group.name}">${group.name}</option>
            </#list>
            </select>
        </div>
        <div class="actions" style="margin-top:30px;">
            <input type="submit" value="Добавить группу" class="btn btn-md btn-block"/>
        </div>
    </form>
</div>
<script src="/static/js/jquery-2.1.4.min.js"></script>
<script src="/static/js/maskedinput.min.js"></script>
<script src="/static/js/phone_number_mask.js"></script>
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
    });
</script>
</body>
</html>