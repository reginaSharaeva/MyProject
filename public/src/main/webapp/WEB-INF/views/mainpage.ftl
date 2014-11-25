<#-- @ftlvariable name="allSubjects" type="java.util.List<ru.dz.labs.api.domain.SubjectInfo>" -->
<#-- @ftlvariable name="allTutors" type="java.util.List<ru.dz.labs.api.domain.TutorInfo>" -->
<h1 style="align-content: center">Main page!</h1>
Привет, ${studentName}! Вот список всех твоих предметов:
<br/><br/>
<#list allSubjects as subject>
    id : ${subject.id}   name : ${subject.name}
<br/><br/>
</#list>

<h2>All tutors</h2>
<#list allTutors as tutor>
    id : ${tutor.id}   name : ${tutor.name}     surname : ${tutor.surname}
    birthday : ${tutor.birthday}   cityId : ${tutor.city.id} cityAlias : ${tutor.city.alias} city: ${tutor.city.name}
    subjects : ${tutor.subjects?has_content?string}
<br/><br/>
</#list>
2014 г.