<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<#macro m_body>
    <form class="form-horizontal" action='' method="POST">
        <fieldset class="reg">
            <div id="legend">
                <legend class="">Register</legend>
            </div>
            <div class="control-group">
                <!-- Username -->
                <label class="control-label"  for="username">Username</label>
                <div class="controls">
                    <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
                    <p class="help-block">Введите имя</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Key -->
                <label class="control-label" for="key"></label>
                <div class="controls">
                    <input type="text" id="key" name="key" placeholder="" class="input-xlarge">
                    <p class="help-block">Введите ключ</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Password-->
                <label class="control-label" for="password">Password</label>
                <div class="controls">
                    <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                    <p class="help-block">Введите пароль</p>
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

            <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success">Зарегистрироваться</button>
                </div>
            </div>
        </fieldset>
    </form>
</#macro>


</body>
</html>