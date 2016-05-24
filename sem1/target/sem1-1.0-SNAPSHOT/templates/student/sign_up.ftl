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
    <link rel="stylesheet" href="/static/css/select2/select2.min.css" type="text/css"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <title>Регистрация ученика</title>
</head>
<body>
<div class="forms">
    <h2>Регистрация ученика</h2>

<@sf.form role="form" action="/students/sign_up" method="post" modelAttribute="student">
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
            <h4 style="color:gray; display:inline;">Выберите свою группу</h4> <br/>
            <h4 style="color:darkred; display: inline;">Формат: город_номерШколы_номерКласса_букваКласса</h4>
            <br/>
            <br/>
            <@sf.select path="group" cssClass="js-example-basic-single js-states form-control" id="group-select">
                <#list groups as group>
                    <@sf.option value="${group.name}" />
                </#list>
            </@sf.select>
        </div>

        <div class="field">
            <@sf.input path="phoneNumber" cssClass="form-control" id="phone_number" placeholder="Телефон" type="text"/>
                                <@sf.errors path="phoneNumber" cssClass="help-block"/>
        </div>

        <div class="field">
            <@sf.input path="interests" cssClass="form-control" placeholder="Интересы" type="text"/>
                                <@sf.errors path="interests" cssClass="help-block"/>
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
