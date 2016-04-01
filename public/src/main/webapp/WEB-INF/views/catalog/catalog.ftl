<#-- @ftlvariable name="user" type="ru.kpfu.itis.toyshop.domain.User" -->
<#-- @ftlvariable name="allCategories" type="java.util.List<ru.kpfu.itis.toyshop.domain.Category>" -->

<#include "../templates/main_template.ftl">
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
                <option value="name,,asc">по названию</option>
                <option value="price,,asc">по возрастанию цены</option>
                <option value="price,,desc">по убыванию цены</option>
            </select>
        </div>
        <div class="col-xs-2">
            <label for="priceSort">Цены:</label>
            <select class="form-control input-sm" id="priceSort">
                <option value="300">менее 300р.</option>
                <option value="300,,500">от 300р. до 500р.</option>
                <option value="500,,1000">от 500р. до 1000р.</option>
                <option value="1000,,2000">от 1000р. до 2000р.</option>
                <option value="2000,,5000">от 2000р. до 5000р.</option>
                <option value="5000,,10000">от 5000р. до 10000р.</option>
                <option value="10000">более 10000р.</option>
            </select>
        </div>
    </form>
    <br>

<div id="catalogContent">
    <#include "catalogContent.ftl" />
</div>
</div>
</#macro>
