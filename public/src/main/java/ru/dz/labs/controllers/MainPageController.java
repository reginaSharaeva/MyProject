package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.api.service.SubjectService;

/**
 * @author Gataullin Kamil
 *         12.10.2014 22:34
 */
@Controller
public class MainPageController extends BaseController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        request.setAttribute("studentName", "Студент");
        request.setAttribute("allSubjects", subjectService.getAllSubjects());
        return "mainpage";
    }
}
