<#-- @ftlvariable name="carts" type="ru.kpfu.itis.toyshop.domain.Cart" -->

<#include "templates/main_template.ftl">
<@mainTemplate title="Toy Shop" />
<#macro m_body>
<h1 class="starter-template">Корзина</h1>
<div class="main-block">
    <#if allCarts?has_content>
        <#list allCarts as carts>
            <br>
            <div class="toy">
                <form action="#" class="toy-img">
                    ${carts.goods.name} ${carts.count!}
                </form>
                <input type="submit" value="Купить">
            </div>

        </#list>
    <#else><p>Нет товаров</p>
    </#if>
</div>
</#macro>


