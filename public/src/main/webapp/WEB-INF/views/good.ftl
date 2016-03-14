<#-- @ftlvariable name="good" type="ru.kpfu.itis.toyshop.domain.Good" -->
<#include "templates/main_template.ftl">
<@mainTemplate />
<#macro m_body>
<body>
<h1 class="starter-template">Описание товара</h1>
<div class="main-block">
    <#if good??>
        <img src="/resources/images/${good.image}" class="img-good">
        <span class="span-good">${good.name}</span>
        <span class="span-good">${good.description}</span>
        <span class="span-good">${good.category.id} ${good.category.name}</span>
        <span class="span-good">${good.price}</span>
        <input type="submit" value="Добавить в корзину">
    <#else>
        Данного товара нет!
    </#if>
</div>
</body>
</#macro>