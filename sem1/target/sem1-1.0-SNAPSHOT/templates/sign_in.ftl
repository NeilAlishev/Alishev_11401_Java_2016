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
    <title>Войти</title>
</head>
<body>
<div class="forms">
    <img src="/static/images/user.png" class="user-logo"/>
    <h2>Войти</h2>
<#if error??>
    <p class="help-block">Проверьте правильность введенных данных</p>
</#if>
    <form role="form" action='/sign_in/process' method='POST'>
        <fieldset>
            <div class="field">
                <label for="username">E-mail</label>
                <input type="email" placeholder="E-mail" name="email" class="form-control" autofocus>
            </div>

            <div class="field">
                <label for="password">Пароль</label>
                <input placeholder="Password" name="password" type="password" class="form-control">
            </div>

            <div class="actions" style="margin-top:30px;">
                <input fullName="submit" type="submit" value="Войти" class="btn btn-md btn-block"/>
            </div>
        </fieldset>
    </form>
    <br />
    <p>Вы не зарегистрированы?</p>
    <a href="/choice" class="btn btn-primary">Регистрация</a>
</div>
</body>
</html>