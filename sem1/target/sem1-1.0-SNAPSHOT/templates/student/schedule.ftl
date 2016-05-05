<#include "../main.ftl">
<#macro actual_page>
<h1 style="text-align: center">Мое расписание</h1>

    <#if schoolDays?has_content>
    <table class="table table-bordered table-hover group-table">
        <#list schoolDays as schoolDay>
            <thead>
            <tr class="info">
                <th colspan="2">
                ${schoolDay.getDayOfWeek()}
                </th>
            </tr>
            </thead>
        <tbody>
            <#assign x = 8>
            <#list schoolDay.getLessons() as lesson>
            <tr>
                <td><h5>${x}:00</h5></td>
                <td>${lesson}</td>
            </tr>
                <#assign x = x + 1>
            </#list>
        </#list>
    </tbody>
    </table>
    <#else>
    <h1>У вас нет расписания</h1>
    </#if>
</#macro>
<@main title="Мое расписание" />