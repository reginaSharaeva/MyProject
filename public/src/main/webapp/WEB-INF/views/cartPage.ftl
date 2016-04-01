<#-- @ftlvariable name="allCarts" type="ru.kpfu.itis.toyshop.domain.Cart" -->
<#-- @ftlvariable name="totalAmount" type="java.math.BigDecimal" -->

<#include "templates/main_template.ftl">
<@mainTemplate title="Toy Shop" />
<#macro m_body>
<h1 class="cart-h">Корзина</h1>
<a href="/catalog"><img src="/resources/images/back.jpg" style="height: 30px; width: 30px"></a>
<div class="main-block">
    <#if allCarts?has_content>
        <#list allCarts as carts>
            <div class="cart-list">
                <form action="#">
                    <img class="cart-list-img" src="/resources/images/${carts.goods.getImage()!}">
                    <span class="cart-name">${carts.goods.getName()!}</span>
                    <span class="cart-price">${carts.goods.getPrice()!} руб.</span>
                    <input class="cart-count btn btn-sm btn-primary" type="button" value="-">
                    <input class="cart-count" form="text" value="${carts.count!}" style="height: 30px; width: 30px";">
                    <input class="cart-count btn btn-sm btn-primary" type="button" value="+">
                    <input class="cart-delete-input btn btn-mdl btn-primary" type="submit" value="Удалить">
                </form>
            </div>
        </#list>
        <#if totalAmount?has_content>
            <div id="legend">
                <legend class="">${totalAmount}</legend>
            </div>
        </#if>
        <input type="submit" value="Оформить заказ" class="cart-order btn-lg btn-success">
    <#else><p>Корзина пуста</p>
    </#if>
</div>
</#macro>


