<#macro mainTemplate title="Toy Shop" styles=[] scripts=[] >
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/custom.css" rel="stylesheet">
    <link href="/resources/css/catalog.css" rel="stylesheet">
    <link href="/resources/css/good.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/main-page.css" rel="stylesheet">
<#list styles as css>
    <link rel="stylesheet" href="/resources/${css}" type="text/css" />
</#list>

    <script src="/resources/js/jquery-1.12.1.min.js"></script>
    <script src="/resources/js/prefixfree.min.js"></script>
    <script src="/resources/js/index.js"></script>
<#list scripts as js>
    <script src="/resources/${js}" type="text/javascript" defer></script>
</#list>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li ><a href="/">Toy Shop</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="/catalog">Каталог
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/catalog">Все товары</a></li>
                        <li><a href="/catalog?id=40">Для самых маленьких</a></li>
                        <li><a href="/catalog?id=33">Для девочек</a></li>
                        <li><a href="/catalog?id=34">Для мальчиков</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/reg"><span class="glyphicon glyphicon-user"></span> Регистрация</a></li>
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