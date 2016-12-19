<#-- @ftlvariable name="currentUser" type="ru.kpfu.itis.toyshop.domain.User" -->
<#-- @ftlvariable name="orderGoods" type="java.util.ArrayList<ru.kpfu.itis.toyshop.domain.Order>" -->
<#include "../templates/main_template.ftl">
<@mainTemplate title="Мир игрушек" scripts=["js/my/cabinet.js"]/>
<#macro m_body>
<div id="main">
<div class="cabinet-title">
    <span>Личный кабинет</span>
    <a href="/cabinet/change"><input class="btn btn-sm btn-primary" type="submit" value="Настройки"></a>
</div>
    <span class="cabinet-user">Пользователь: ${currentUser.name}</span>
    <span class="cabinet-order">Заказы</span>
    <#if orderGoods?has_content>
        <#list orderGoods as orders>
            <div class="cabinet-order-container">
                <table class="table1">
                    <tr>
                        <th class="column1">название</th>
                        <th class="column2">количество</th>
                        <th class="column3">цена</th>
                    </tr>
                    <#list orders.getOrder_goods() as goods>
                        <tr>
                            <td class="column1">${goods.goods.name}</td>
                            <td class="column2">${goods.count}</td>
                            <td class="column3">${goods.goods.price}</td>
                        </tr>
                    </#list>
                </table>
                <a href="/cabinet"><input class="btn btn-sm btn-primary cabinet-cancel js_removeOrder" data-id="${orders.id}" type="button" value="отменить"></a>
            </div>
        </#list>
    </#if>
</div>
</#macro>