import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dz.labs.api.domain.CityInfo;
import ru.dz.labs.api.domain.SubjectInfo;
import ru.dz.labs.api.domain.TutorInfo;
import ru.dz.labs.api.service.CityService;
import ru.dz.labs.api.service.SubjectService;
import ru.dz.labs.api.service.TutorService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author Gataullin Kamil
 *         12.10.2014 0:03
 */
public class TestHibernate {

    public static CityService cityService;
    public static TutorService tutorService;
    public static SubjectService subjectService;

    public static void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "tutor-core.xml" }, true);
        cityService = (CityService) context.getBean("cityService");
        tutorService = (TutorService) context.getBean("tutorService");
        subjectService = (SubjectService) context.getBean("subjectService");
    }

    public static void main(String[] args) throws SQLException {
        init();
        testSubject();
        testTutor();
    }

    public static void testSubject() {
        List<SubjectInfo> subjects = subjectService.getAllSubjects();
        System.out.println("======== All subjects =========");
        for(SubjectInfo subject : subjects) {
            System.out.println("id : " + subject.getId() + ", name : " + subject.getName());
        }
        System.out.println("=============================");
    }

    public static void testTutor() {
        CityInfo cityInfo = new CityInfo("khv", "Хабаровск");
        cityService.add(cityInfo);

        tutorService.add(new TutorInfo("Имя", "Фамилия", "Отчество", new Date(), null, cityInfo));
        List<TutorInfo> tutors = tutorService.getAllTutor();
        System.out.println("======== All tutors =========");
        for(TutorInfo tutorInfo : tutors) {
            System.out.println("id : " + tutorInfo.getId() + ", name : " + tutorInfo.getName());
        }
        System.out.println("=============================");
    }
}
