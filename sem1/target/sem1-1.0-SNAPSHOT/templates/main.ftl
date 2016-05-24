<#macro main title customScript=[] customCSS=[]>
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
    <#if customCSS?size != 0>
        <#list customCSS as stylesheet>
        ${stylesheet}
        </#list>
    </#if>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <title>
    ${title}
    </title>
</head>
<body>
<div id="wrapper">
    <div id="page-wrapper">
        <div class="container-fluid">
            <#include "navigation.ftl">
    <@actual_page/>
        </div>
    </div>
</div>
<script src="/static/js/jquery-2.1.4.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
    <#if customScript?size != 0>
        <#list customScript as script>
        ${script}
        </#list>
    </#if>
</body>
</html>
</#macro>