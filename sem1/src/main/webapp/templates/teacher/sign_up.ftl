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
    <title>Регистрация учителя</title>
</head>
<body>
<div class="forms">
    <h2>Регистрация учителя</h2>

<@sf.form role="form" action="/teachers/sign_up" method="post" modelAttribute="teacher">
    <fieldset>
        <div class="field">
            <@sf.input path="fullName" cssClass="form-control" placeholder="Полное имя" type="text"/>
                                <@sf.errors path="fullName" cssClass="help-block"/>
        </div>

        <div class="field">
            <@sf.input path="email" cssClass="form-control" placeholder="Email" type="email"/>
                                <@sf.errors path="email" cssClass="help-block"/>
        </div>

        <div class="field">
            <@sf.input path="qualification" cssClass="form-control" placeholder="Квалификация" type="text"/>
                                <@sf.errors path="qualification" cssClass="help-block"/>
        </div>

        <div class="field">
            <@sf.input path="contacts" cssClass="form-control" placeholder="Контакты" type="text"/>
                                <@sf.errors path="contacts" cssClass="help-block"/>
        </div>

        <div class="field">
            <@sf.input path="password" cssClass="form-control" placeholder="Пароль" type="password"/>
                                <@sf.errors path="password" cssClass="help-block"/>
        </div>
        <div class="field">
            <@sf.input path="passwordConfirmation" cssClass="form-control" placeholder="Подтверждение пароля" type="password"/>
                                <@sf.errors path="passwordConfirmation" cssClass="help-block"/>
        </div>
        <div class="actions" style="margin-top:30px;">
            <input type="submit" value="Зарегистрироваться" class="btn btn-md btn-block"/>
        </div>
    </fieldset>
</@sf.form>
</div>
</body>
</html>
