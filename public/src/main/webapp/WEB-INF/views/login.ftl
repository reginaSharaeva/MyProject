
<#include "templates/main_template.ftl">
<@mainTemplate title="Мир игрушек" />
<#macro m_body>
<div class="account-in">
    <div class="container">
        </br>
        </br>
        </br>
        </br>
        <div id="legend">
            <legend class="">Регистрация</legend>
        </div>
        <div class="col-md-7 account-top">
            <#if error?has_content>
                <div style="color: red;">Ошибка! Пожалуйста проверьте Ваш e-mail и пароль!</div>
            </#if>
            <form name="authForm" id="authForm" action="/j_spring_security_check" method="post">
                <div>
                    <span>Email</span>
                    <input type="text" name="j_username" />
                </div>
                <div>
                    <span class="pass">Password</span>
                    <input type="password" name="j_password" />
                </div>
                <div>
                    </br>
                    <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                    <label for="remember_me" class="inline">Запомнить меня</label>
                </div>
                <input type="submit" value="Login" class="btn btn btn-lg btn-success"/>
                <a href="/reg" style="margin-left: 15px;">Зарегистрироваться</a>
            </form>
        </div>
        <div class="col-md-5 left-account "></div>
        <div class="clearfix"> </div>
    </div>
</div>
</#macro>






