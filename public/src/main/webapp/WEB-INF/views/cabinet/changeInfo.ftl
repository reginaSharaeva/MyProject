<#-- @ftlvariable name="incorrect" type="boolean" -->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../templates/main_template.ftl">
<@mainTemplate title="Мир Игрушек" />
<#macro m_body>
<div class="account-in">
    <div class="container">
        <@form.form commandName="changeForm" action="/cabinet/change" acceptCharset="UTF-8" method="post">
            </br>
            </br>
            </br>
            </br>
        <div class="register-top-grid">
            <div id="legend">
                <legend class="">Настройки</legend>
            </div>
        <#--<@form.errors path="*" cssStyle="color: red;" />-->
            <div>
                <span>Name<label>*</label></span>
                <@form.input path="name"/>
                <@form.errors path="name" cssStyle="color: red;" />
                <p class="help-block">Введите имя (имя может содержать любые символы кроме пробела)</p>
            </div>
            <div>
                <span>Password</span>
                <@form.password path="password" />
            </div>
            <div>
                <span>Confirm Password</span>
                <@form.password path="confirmPassword"/>
                <#if incorrect?has_content>
                    <span style="color: red;">Не совпадает с паролем!</span>
                </#if>
            </div>
            <div class="clearfix"> </div>
            <div class="clearfix"> </div>
            <div class="register-but">
                <input type="submit" value="Сохранить" class="btn btn btn-lg btn-success">
                <div class="clearfix"> </div>
            </div>
        </@form.form>
    </div>
    </div>
</#macro>

