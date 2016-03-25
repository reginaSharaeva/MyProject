<#-- @ftlvariable name="allCarts" type="ru.kpfu.itis.toyshop.domain.Cart" -->

<#include "templates/main_template.ftl">
<@mainTemplate title="Toy Shop" />
<#macro m_body>
<h1 class="starter-template">Корзина</h1>
<div class="main-block">
    <#if allCarts?has_content>
        <#list allCarts as carts>
            <div>
                <form action="#">
                    <p style="text-indent: 20px">${carts.goods.getName()!}
                    <input type="button" value="-">
                    <input form="text" value="${carts.count!}" style="height: 25px; width: 25px";">
                    <input type="button" value="+">

                    <input type="submit" value="Удалить">
                    <input type="submit" value="Купить"></p>
                </form>
            </div>
        </#list>
    <#else><p>Корзина пуста</p>
    </#if>
</div>
</#macro>


