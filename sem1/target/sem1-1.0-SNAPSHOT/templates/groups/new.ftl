<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
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
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <title>Добавление группы</title>
</head>
<body>
<a href="/" style="float:left; margin-left: 20pt;"><h4>Обратно</h4></a>
<div class="forms">
    <h2>Добавление группы</h2>

<@sf.form role="form" action="/groups/create" method="post" modelAttribute="group">
    <fieldset>
        <div class="field">
            <b style="color:darkred;">Введите группу в формате город_номерШколы_номерКласса_букваКласса</b>
            <br />
            <br />
            <@sf.input path="name" cssClass="form-control" placeholder="Группа" type="text"/>
                                <@sf.errors path="name" cssClass="help-block"/>
        </div>
        <div class="actions" style="margin-top:30px;">
            <input type="submit" value="Добавить группу" class="btn btn-md btn-block"/>
        </div>
    </fieldset>
</@sf.form>
</div>
</body>
</html>
