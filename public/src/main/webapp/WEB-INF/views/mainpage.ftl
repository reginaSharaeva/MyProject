<#-- @ftlvariable name="allSubjects" type="java.util.List<ru.dz.labs.api.domain.SubjectInfo>" -->
<h1 style="align-content: center">Main page!</h1>
Привет, ${studentName}! Вот список всех твоих предметов:
<br/><br/>
<#list allSubjects as subject>
    id : ${subject.id}   name : ${subject.name}
<br/><br/>
</#list>
2014 г.