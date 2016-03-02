<#include "templates/main_template.ftl">
<@mainTemplate title="Toy Shop" />
<#macro m_body>
<h1 class="starter-template">Каталог</h1>
<div class="main-block">
    <#if allGoods?has_content>
        <#list allGoods as goods>

            <div class="toy">
                <form action="#">
                    <a href="/good">${goods.name!} ${goods.color!} ${goods.price!}</a>
                </form>
            </div>
        </#list>
    <#else><p>Нет товаров</p>
    </#if>


</div>
</#macro>

