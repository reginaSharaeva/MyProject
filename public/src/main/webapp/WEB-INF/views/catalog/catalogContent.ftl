<#-- @ftlvariable name="allGoods" type="java.util.List<ru.kpfu.itis.toyshop.domain.Good>" -->
<#-- @ftlvariable name="goodInCart" type="boolean" -->
<#-- @ftlvariable name="limit" type="Integer" -->
<#-- @ftlvariable name="goodsCount" type="Integer" -->
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
        <#if goodInCart?has_content>
            <a href="/cart"><input type="submit" value="Перейти в корзину" class="add-tocard-catalog"></a>
        <#else>
            <a href="/cart"><input type="submit" value="Добавить в корзину" class="add-tocard-catalog js_addToCart" data-id="${goods.id}"></a>
        </#if>
    </div>
    </#list>
    <#if limit < goodsCount>
    <a href="/catalog?id=${id}"><input type="submit" value="Показать еще" class="btn btn btn-lg btn-success js_showMore" data-limit="${limit+10}"></a>
    </#if>
<#else>
<p>Нет товаров</p>
</#if>