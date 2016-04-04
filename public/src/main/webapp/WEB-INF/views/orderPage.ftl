<#-- @ftlvariable name="totalAmount" type="java.math.BigDecimal" -->
<#include "templates/main_template.ftl">
<@mainTemplate title="Мир игрушек" />
<#macro m_body>
<form class="form-horizontal" action='' method="POST">
   <fieldset class="ord">
       <div id="legend">
           <legend class="">Оформление заказа</legend>
       </div>
       <div class="control-group">
           <!-- Name-->
           <label class="control-label" for="address">Ф.И.О</label>
           <div class="controls">
               <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
               <p class="help-block">Введите имя получателя</p>
           </div>
       </div>
       <div class="control-group">
           <!-- Address-->
           <label class="control-label" for="address">Адрес</label>
           <div class="controls">
               <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
                  <p class="help-block">Введите адрес доставки</p>
           </div>
       </div>
       <div class="control-group">
           <!-- PayWay -->
           <label class="control-label" for="pay">Способ оплаты</label>
           <div class="controls">
               <select class="form-control input-sm" id="payWay" style="width: 180px">
                   <option>Наличными при доставке</option>
                   <option>Картой при заказе</option>
               </select>
           </div>
       </div>
       <div class="control-group">
           <!--Total amount-->
           <label class="control-label" for="password">Итоговая сумма</label>
           <div class="controls">
               <#if totalAmount?has_content>
                   <input type="text" value="${totalAmount}.00 руб." placeholder="" class="input-xlarge">
               </#if>
           </div>
       </div>
       </br>
       <div class="control-group">
               <!-- Button -->
            <div class="controls">
                  <button class="btn btn-success">Заказать</button>
            </div>
       </div>
    </fieldset>
</form>
</#macro>