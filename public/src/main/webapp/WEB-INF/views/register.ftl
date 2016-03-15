<#include "templates/main_template.ftl">
<@mainTemplate title="Toy Shop" />

<#macro m_body>
<form class="form-horizontal" action='' method="POST">
    <fieldset class="reg">
        <div id="legend">
            <legend class="">Register</legend>
        <div class="control-group">
            <!-- E-mail -->
            <label class="control-label" for="email">E-mail</label>
            <div class="controls">
                <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
                <p class="help-block">Введите Ваш E-Mail для получения ключа</p>
                <a href="/key"><input type="submit" value="Получить ключ"></a>
            </div>
        </div>
    </fieldset>
</form>
</#macro>

