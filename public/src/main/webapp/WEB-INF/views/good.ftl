<#include "templates/main_template.ftl">
<@mainTemplate title="Toy Shop" />
<#macro m_body>
<h1 class="starter-template">Описание товара</h1>
<div class="main-block">
    <form action="#">
        <a href="/good">${goods.name!} ${goods.color!} ${goods.price!}</a>
    </form>
    <input type="submit" value="Добавить в корзину">
</div>
</#macro>