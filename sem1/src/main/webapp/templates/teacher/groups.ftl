<#include "../main.ftl">
<#macro actual_page>

<h1 style="text-align: center"><a href="/teacher/groups/add">Добавить группу</a></h1>
    <#if groups?has_content>
        <#list groups as group>
        <h1>${group.getName()}</h1>
        <table class="table table-bordered table-hover group-table">
            <thead>
            <tr>
                <th>
                    Имя
                </th>
                <th>
                    Общий балл
                </th>
            </tr>
            </thead>
            <tbody>
                <#list group.getStudents() as student>
                <tr>
                    <td><h5>${student.getFullName()}</h5></td>
                    <td>100</td>
                </tr>
                </#list>
            </tbody>
        </table>
        </#list>
    <#else>
    <h1>У вас нет активных групп</h1>
    </#if>
</#macro>
<@main title="Мои ученики"/>
