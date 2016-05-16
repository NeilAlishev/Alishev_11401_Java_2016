<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/">Schooley</a>
    </div>
    <ul class="nav navbar-right top-nav">
    <#if current_user.role == "ROLE_STUDENT">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle homework-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i>
                <#if homework?size != 0>
                    <span style="color: #428bca;">У вас новая домашняя работа</span>
                </#if>
                <b class="caret"></b></a>
            <ul class="dropdown-menu message-dropdown">
            <#list homework as task>
                <li class="message-preview">
                    <a href="#">
                        <div class="media">
                            <div class="media-body">
                                <h5 class="media-heading"><strong>${task.teacher.fullName} - ${task.subject}</strong>
                                </h5>
                                <p class="small text-muted"><i class="fa fa-clock-o"></i> ${task.deadline}</p>
                                <p>${task.message}</p>
                            </div>
                        </div>
                    </a>
                </li>
            </#list>
            </ul>
        </li>
    </#if>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                    class="fa fa-user"></i> ${current_user.getFullName()} <b
                    class="caret"></b></a>
            <ul class="dropdown-menu">
                <li>
                    <a href="/logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                </li>
            </ul>
        </li>
    </ul>
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav">
            <li>
                <a href="/"><i class="fa fa-fw fa-dashboard"></i> Профиль</a>
            </li>
        <#if current_user.getRole() == "ROLE_STUDENT">
            <li>
                <a href="/student/teachers"><i class="fa fa-fw fa-desktop"></i> Мои учителя</a>
            </li>
            <li>
                <a href="/student/classmates"><i class="fa fa-fw fa-file"></i> Мой класс</a>
            </li>
            <li>
                <a href="/student/schedule"><i class="fa fa-fw fa-table"></i> Мое расписание</a>
            </li>
            <li>
                <a href="/student/marks"><i class="fa fa-fw fa-edit"></i> Мои оценки</a>
            </li>
            <li>
                <a href="/statistics"><i class="fa fa-fw fa-bar-chart-o"></i> Моя статистика</a>
            </li>
        <#elseif current_user.getRole() == "ROLE_TEACHER">
            <li>
                <a href="/teacher/groups"><i class="fa fa-fw fa-bar-chart-o"></i> Мои ученики</a>
            </li>
            <li>
                <a href="/marks/new"><i class="fa fa-fw fa-edit"></i> Поставить оценку</a>
            </li>
        <#else>
            <li>
                <a href="/groups/new"><i class="fa fa-fw fa-table"></i> Добавить группу</a>
            </li>

            <li>
                <a href="/admin/schedule/add"><i class="fa fa-fw fa-table"></i> Добавить расписание</a>
            </li>
        </#if>
        </ul>
    </div>
</nav>