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
    <link href="/static/css/expromptum.css" rel="stylesheet" type="text/css"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <title>Добавление расписания</title>
</head>
<body>
<a href="/" style="float:left; margin-left: 20pt;"><h4>Обратно</h4></a>
<div class="schedule-form">
    <form action="/admin/schedule/add" method="POST">
    <#if error??>
        <div class="help-block" style="color: red;">
            <h3>${error}</h3>
        </div>
    </#if>
        <h2>Понедельник:</h2>
        <p class="field">
            <input name="0" data-xp="repeat: true"/>

            <button class="repeat_append_button">+</button>
            <button class="repeat_remove_button">&minus;</button>
        </p>
        <hr/>
        <h2>Вторник:</h2>
        <p class="field">
            <input name="1" data-xp="repeat: true"/>

            <button class="repeat_append_button">+</button>
            <button class="repeat_remove_button">&minus;</button>
        </p>
        <hr/>
        <h2>Среда:</h2>
        <p class="field">
            <input name="2" data-xp="repeat: true"/>

            <button class="repeat_append_button">+</button>
            <button class="repeat_remove_button">&minus;</button>
        </p>
        <hr/>
        <h2>Четверг:</h2>
        <p class="field">
            <input name="3" data-xp="repeat: true"/>

            <button class="repeat_append_button">+</button>
            <button class="repeat_remove_button">&minus;</button>
        </p>
        <hr/>
        <h2>Пятница:</h2>
        <p class="field">
            <input name="4" data-xp="repeat: true"/>

            <button class="repeat_append_button">+</button>
            <button class="repeat_remove_button">&minus;</button>
        </p>
        <hr/>
        <h2>Суббота:</h2>
        <p class="field">
            <input name="5" data-xp="repeat: true"/>

            <button class="repeat_append_button">+</button>
            <button class="repeat_remove_button">&minus;</button>
        </p>
        <hr/>
        <h2>Введите группу</h2>
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
        <hr/>
        <input type="submit" value="Добавить расписание"/>
    </form>
</div>


<script src="/static/js/jquery-2.1.4.min.js"></script>
<script src="/static/js/expromptum.min.js"></script>
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
<script>
    expromptum();
</script>
</body>
</html>