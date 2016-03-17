<#-- @ftlvariable name="allGoods" type="java.util.List<ru.kpfu.itis.toyshop.domain.Good>" -->
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
        <a href="/cart?cartGoodId=${goods.id}"><input type="submit" value="Добавить в корзину" class="add-tocard-catalog"></a>
    </div>
    </#list>
<#else>
    <p>Нет товаров</p>
</#if>