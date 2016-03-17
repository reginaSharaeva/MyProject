<#-- @ftlvariable name="user" type="ru.kpfu.itis.toyshop.domain.User" -->
<#-- @ftlvariable name="allCategories" type="java.util.List<ru.kpfu.itis.toyshop.domain.Category>" -->

<#include "templates/main_template.ftl">
<@mainTemplate title="Toy Shop" scripts=["js/my/catalog.js"] />
<#macro m_body>
<h1 class="starter-template">Каталог</h1>
<div class="main-block">

    <form class="search-catalog">
        <div class="col-xs-2">
            <label for="categoryFilter">Выберите категорию:</label>
            <select class="form-control input-sm" id="categoryFilter">
                <#if allCategories?has_content>
                    <#list allCategories as categories>
                        <option value="${categories.id}">${categories.alias}</option>
                    </#list>
                </#if>
            </select>
        </div>

        <div class="col-xs-2">
            <label for="categorySort">Сортировать:</label>
            <select class="form-control input-sm" id="categorySort">
                <option>по названию</option>
                <option>по возрастанию цены</option>
                <option>по убыванию цены</option>
            </select>
        </div>
    </form>
    <br>

<div id="catalogContent">
    <#include "catalogContent.ftl" />
</div>
</div>
</#macro>

