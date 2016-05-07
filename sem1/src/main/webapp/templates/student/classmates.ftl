<#include "../main.ftl">
<#macro actual_page>
<h1 style="text-align: center">Мой класс</h1>

    <#if studentsMap?has_content>
    <table class="table table-bordered table-hover group-table">
        <thead>
        <tr>
            <th>
                Ученик
            </th>
            <th>
                Средний балл
            </th>
        </tr>
        </thead>
        <tbody>
            <#assign counter = 0>
            <#list studentsMap?keys as avgScore>
                <#if counter < 3>
                <tr class="success">
                <#else>
                <tr>
                </#if>
                <td><h5>${studentsMap[avgScore]}</h5></td>
                <td>${avgScore}</td>
            </tr>
                <#assign counter++>
            </#list>
        </tbody>
    </table>
    <#else>
    <h1>Вы не в классе</h1>
    </#if>
</#macro>
<@main title="Мой класс" />