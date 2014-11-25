<#-- @ftlvariable name="allSubjects" type="java.util.List<ru.dz.labs.api.domain.SubjectInfo>" -->
<#-- @ftlvariable name="allTutors" type="java.util.List<ru.dz.labs.api.domain.TutorInfo>" -->
<h1 style="align-content: center">Main page!</h1>
Привет, ${studentName}! Вот список всех твоих предметов:
<br/><br/>
<#list allSubjects as subject>
    id : ${subject.id}   name : ${subject.name?html}
<br/><br/>
</#list>

<h2>All tutors</h2>
<#list allTutors as tutor>
    id : ${tutor.id} name : ${tutor.name?html} surname : ${tutor.surname?html} birthday : ${tutor.birthday?string("dd.MM.yyyy")}<br/>
    cityId : ${tutor.city.id} cityAlias : ${tutor.city.alias} city: ${tutor.city.name}<br/>
    subjects : ${tutor.subjects?has_content?string}
<br/><br/>
</#list>
2014 г.