<#include "../main.ftl">
<#macro actual_page>

<h1 style="text-align: center"><a href="/teacher/groups/add">Добавить группу</a></h1>
    <#if groups?has_content>
        <#list groups as group>
        <h1>${group.getName()}</h1>
        <button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#myModal${group.getId()}">
            Новое домашнее задание
        </button>
        <div class="modal fade" id="myModal${group.getId()}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Новое домашнее задание</h4>
                    </div>

                    <div class="modal-body">
                        <form action="/homeworks/create" class="create-homework" method="POST">
                            <h4>Предмет</h4>
                            <div class="field">
                                <input type="text" name="subject" placeholder="Предмет" class="form-control subject-field"/>
                            </div>
                            <h4>Текст задания</h4>
                            <div class="field">
                                <textarea class="form-control message-field" name="message" placeholder="Введите текст задания"
                                          rows="5"></textarea>
                            </div>
                            <h4>Cрок сдачи</h4>
                            <div class="field">
                                <input type="text" name="deadline" class="form-control datepicker"
                                       style="text-align: center;"/>
                            </div>
                            <input type="hidden" name="groupId" value="${group.getId()}" class="groupId"/>
                            <div class="actions" style="margin-top:30px;">
                                <input type="submit" value="Добавить домашнее задание"
                                       class="btn btn-md btn-block"/>
                            </div>
                        </form>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                    </div>
                </div>
            </div>
        </div>

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
                <#list group.students as student>
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
<@main title="Мои ученики" customScript=['<script src="/static/js/jquery-ui.min.js" type="text/javascript"></script>',
'<script>
    $(function () {
        $(".datepicker").datepicker({dateFormat: "dd-mm-yy"});
    });
</script>
', '<script src="/static/js/homework-add-ajax.js" type="text/javascript"></script>'] customCSS=['<link rel="stylesheet" href="/static/css/jquery-ui.min.css" type="text/css"/>',
'<link rel="stylesheet" href="/static/css/jquery-ui.structure.min.css" type="text/css"/>',
'<link rel="stylesheet" href="/static/css/jquery-ui.theme.min.css" type="text/css"/>']/>
