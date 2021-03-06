<#include "main.ftl">
<#macro actual_page>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                ${current_user.getFullName()}
                    <br/>
                    <#if current_user.getRole() == "ROLE_STUDENT">
                        <small>Ученик</small>
                    <#elseif current_user.getRole() == "ROLE_TEACHER">
                        <small>Учитель</small>
                    <#else>
                        <small>Администратор</small>
                    </#if>
                </h1>
            </div>
        </div>
        <h2 style="text-align: center;">Мой профиль</h2>
        <#if current_user.getRole() == "ROLE_STUDENT">
            <div class="row profile-content">
                <img src="static/images/gray.png" class="img-circle profile-image" width="200px" height="200px"/>
                <div class="col-lg-12">
                    <div>
                        <ul>
                            <h3 style="color:dimgray;">Номер группы:</h3>
                            <li><h4>${current_user.getGroup().getName()}</h4></li>
                            <h3 style="color:dimgray;">Номер телефона:</h3>
                            <li><h4>${current_user.getPhoneNumber()}</h4></li>
                            <h3 style="color:dimgray;">Интересы</h3>
                            <li><h4>${current_user.getInterests()}</h4></li>
                            <h3 style="color:dimgray;">Средний балл по всем предметам</h3>
                            <li><h4>${average}</h4></li>
                        </ul>
                    </div>
                </div>
            </div>
        <#elseif current_user.getRole() == "ROLE_TEACHER">
            <div class="row profile-content">
                <img src="static/images/gray.png" class="img-circle profile-image" width="200px" height="200px"/>
                <div class="col-lg-12">
                    <div>
                        <ul>
                            <h3 style="color:dimgray;">Квалификация:</h3>
                            <li><h4>${current_user.getQualification()}</h4></li>
                            <h3 style="color:dimgray;">Контакты:</h3>
                            <li><h4>${current_user.getContacts()}</h4></li>
                        </ul>
                    </div>
                </div>
            </div>
        <#else>
            <div class="row profile-content">
                <div class="col-lg-12">
                    <h3>Статистика:</h3>
                    <div>
                        <ul>
                            <h3 style="color:dimgray">Количество зарегистрированных учеников</h3>
                            <li><h4>${number_of_students}</h4></li>
                            <h3 style="color:dimgray">Количество зарегистрированных учителей</h3>
                            <li><h4>${number_of_teachers}</h4></li>
                        </ul>
                    </div>
                </div>
            </div>
        </#if>
    </div>
</div>
</#macro>
<@main title="Главная" />