<#include "templates/main_template.ftl">
<@mainTemplate title="Toy Shop" />

<#macro m_body>
<form class="form-horizontal" action='' method="POST">
    <fieldset class="reg">
        <div id="legend">
            <legend class="">Регистрация</legend>
            <div class="control-group">
                <!-- Username -->
                <label class="control-label"  for="username">Username</label>
                <div class="controls">
                    <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
                    <p class="help-block">Введите имя (имя может содержать любые символы кроме пробела)</p>
                </div>
            </div>
            <div class="control-group">
                <!-- E-mail -->
                <label class="control-label" for="email">E-mail</label>
                <div class="controls">
                    <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
                    <p class="help-block">Введите Ваш E-Mail</p>
                </div>
            </div>
            <div class="control-group">
                <!-- Password-->
                <label class="control-label" for="password">Password</label>
                <div class="controls">
                    <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                    <p class="help-block">Введите пароль (пароль должен содержать не менее 7 символов)</p>
                </div>
            </div>
            <div class="control-group">
                <!-- Password -->
                <label class="control-label"  for="password_confirm">Password (Confirm)</label>
                <div class="controls">
                    <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
                    <p class="help-block">Подтвердите пароль</p>
                </div>
            </div>
            <br>
            <div class="control-group">
                <div class="controls">
                    <button class="btn btn-success">Зарегистрироваться</button>
                </div>
            </div>
        </div>
    </fieldset>
</form>
</#macro>

