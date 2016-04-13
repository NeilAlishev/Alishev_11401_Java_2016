<#macro main title="Hello" customScript=[] customCSS=[]>
<html>
<head>
    <title>
    </title>
</head>
<body>
<#include "header.ftl">
<div>
    <@actual_page/>
</div>
<#include "footer.ftl">
</body>
</html>
</#macro>