<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="mySite">
    <meta name="author" content="Neil">
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
    <form name='f' action='/login' method='POST'>
        <div class="field">
            <label for="username">Логин</label>
            <input type='text' id="username" name='username' value='' class="form-control">
        </div>

        <div class="field">
            <label for="password">Пароль</label>
            <input type='password' id="password" name="password" class="form-control">
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="actions" style="margin-top:30px;">
            <input name="submit" type="submit" value="Login" class="btn btn-md btn-block"/>
        </div>
    </form>
</div>
</body>
</html>