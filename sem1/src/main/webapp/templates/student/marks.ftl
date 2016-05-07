<#include "../main.ftl">
<#macro actual_page>
<h1 style="text-align: center">Мои оценки</h1>

    <#if marks?has_content>
    <table class="table table-bordered table-hover group-table">
        <thead>
        <tr>
            <th>
                Предмет
            </th>
            <th>
                Учитель
            </th>
            <th>
                Оценка
            </th>
            <th>
                Дата
            </th>
        </tr>
        </thead>
        <tbody>
            <#list marks as mark>
            <tr>
                <td><h5>${mark.subject}</h5></td>
                <td>${mark.teacher.fullName}</td>
                <td>${mark.score}</td>
                <td>${mark.createdAt}</td>
            </tr>
            </#list>
        </tbody>
    </table>
    <#else>
    <h1>У вас нет оценок</h1>
    </#if>
</#macro>
<@main title="Мои оценки" />