<#-- @ftlvariable name="allGoods" type="ru.kpfu.itis.toyshop.domain.Good" -->
<#-- @ftlvariable name="user" type="ru.kpfu.itis.toyshop.domain.User" -->

<#include "templates/main_template.ftl">
<@mainTemplate title="Toy Shop" />
<#macro m_body>
<h1 class="starter-template">Каталог</h1>
<div class="main-block">

    <form class="search-catalog">
        <div class="col-xs-3">
            <select class="form-control input-sm">
                <option>Средний - 1</option>
                <option>Средний - 2</option>
            </select>
        </div>

        <div class="col-xs-2">
            <select class="form-control input-sm">
                <option>Средний - 1</option>
                <option>Средний - 2</option>
            </select>
        </div>
    </form>


    <#if allGoods?has_content>
    <#list allGoods as goods>
        <div class="toy">
            <form action="#">
                <div class="toy-catalog">
                    <a href="/good/${goods.id}" class="href-catalog">
                        <img src="/resources/images/${goods.image}" class="toy-search">
                    </a>
                </div>
                <a href="/good/${goods.id}" class="href-catalog">${goods.name!} ${goods.color!} ${goods.price!}</a>
            </form>
            <a href="/cart?cartGoodId=${goods.id}&userId=${user.id}"><input type="submit" value="Добавить в корзину" class="add-tocard-catalog"></a>
        </div>

    </#list>
<#else><p>Нет товаров</p>
</#if>
</div>
</#macro>

