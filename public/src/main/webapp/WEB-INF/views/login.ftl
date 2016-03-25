<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "templates/main_template.ftl">
<@mainTemplate title="Toy Shop" />
<#macro m_body>
<div class="account-in" xmlns="http://www.w3.org/1999/html">
    <div class="container">
        <@form.form commandName="logForm" action="/login" acceptCharset="UTF-8" method="post">
            </br>
            </br>
            </br>
        </br>
        <div class="register-top-grid">
            <div id="legend">
                <legend class="">Вход</legend>
            </div>
        <#--<@form.errors path="*" cssStyle="color: red;" />-->
            <div>
                <span>E-Mail<label>*</label></span>
                <@form.input path="email"/>
                <@form.errors path="email" cssStyle="color: red;" />
                <p class="help-block">Введите Ваш E-Mail</p>
            </div>

            <div>
                <span>Password<label>*</label></span>
                <@form.password path="password" />
                <@form.errors path="password" cssStyle="color: red;" />
                <p class="help-block">Введите пароль (пароль должен содержать не менее 7 символов)</p>
            </div>
            <div class="clearfix"> </div>
            <div class="clearfix"> </div>
            <div class="register-but">
                <input type="submit" value="Войти" class="btn btn-lg btn-success">
                <div class="clearfix"> </div>
            </div>
        </@form.form>
    </div>
    </div>
</#macro>

