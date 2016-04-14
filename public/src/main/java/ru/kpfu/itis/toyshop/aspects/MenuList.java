package ru.kpfu.itis.toyshop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.toyshop.domain.Category;
import ru.kpfu.itis.toyshop.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Регина on 05.04.2016.
 */
@Aspect
@Component
public class MenuList {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CategoryService categoryService;

    @Pointcut("@annotation(ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList)")
    public void includeMenuListMethod() {
    }

    @Before("includeMenuListMethod()")
    public void includeMenuInfo() {
        request.setAttribute("listMenu", categoryService.getCategoryForMenu((long) 45));
    }
}
