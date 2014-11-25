import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dz.labs.api.domain.CityInfo;
import ru.dz.labs.api.domain.SubjectInfo;
import ru.dz.labs.api.domain.TutorInfo;
import ru.dz.labs.api.service.CityService;
import ru.dz.labs.api.service.SubjectService;
import ru.dz.labs.api.service.TutorService;

import java.util.Date;
import java.util.List;

/**
 * @author Gataullin Kamil
 *         23.11.2014 23:21
 */
public class NewTestClass {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "tutor-core.xml" }, true);
//        SubjectService subjectService = (SubjectService) context.getBean("subjectService");
//
//        List<SubjectInfo> subjects = subjectService.getAllSubjects();
//        System.out.println("======== All subjects =========");
//        for(SubjectInfo subject : subjects) {
//            System.out.println("id : " + subject.getId() + ", name : " + subject.getName());
//        }
//        System.out.println("=============================");

//        CityService cityService = (CityService) context.getBean("cityService");
//        CityInfo cityInfo = new CityInfo("msc", "Москва");
//        cityService.add(cityInfo);

        TutorService tutorService = (TutorService) context.getBean("tutorService");
//        tutorService.add(new TutorInfo("Камиль", "Гатауллин", "Рузалевич", new Date(), null, cityInfo));
        List<TutorInfo> tutors = tutorService.getAllTutor();
        System.out.println("======== All tutors =========");
        for(TutorInfo tutorInfo : tutors) {
            System.out.println("id : " + tutorInfo.getId() + ", name : " + tutorInfo.getName() +
                ", city : " + tutorInfo.getCity().getName());
        }
        System.out.println("=============================");
    }
}
