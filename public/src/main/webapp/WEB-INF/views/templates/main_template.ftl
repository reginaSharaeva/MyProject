<#macro mainTemplate title="Toy Shop">
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/custom.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Toy Shop</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Каталог
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/catalog">Все товары</a></li>
                        <li><a href="#">Машинки</a></li>
                        <li><a href="#">Куклы</a></li>
                        <li><a href="#">Конструкторы</a></li>
                        <li><a href="#">Детская посуда</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Регистрация</a></li>
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Вход</a></li>
                <li><a href="/cart"> Корзина</a></li>
            </ul>
        </div>
    </div>
</nav>
    <@m_body/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
</#macro>