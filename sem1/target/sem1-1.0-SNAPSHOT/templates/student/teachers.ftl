<#include "../main.ftl">
<#macro actual_page>
<h1 style="text-align: center">Мои учителя</h1>

    <#if teachers?has_content>
    <table class="table table-bordered table-hover group-table">
        <thead>
        <tr>
            <th>
                Имя
            </th>
            <th>
                Квалификация
            </th>
        </tr>
        </thead>
        <tbody>
            <#list teachers as teacher>
            <tr>
                <td><h5>${teacher.getFullName()}</h5></td>
                <td>${teacher.getQualification()}</td>
            </tr>
            </#list>
        </tbody>
    </table>
    <#else>
    <h1>У вас нет учителей</h1>
    </#if>
</#macro>
<@main title="Мои учителя" />