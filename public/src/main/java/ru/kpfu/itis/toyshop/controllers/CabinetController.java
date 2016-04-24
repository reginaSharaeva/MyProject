package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.HashMake;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.Order;
import ru.kpfu.itis.toyshop.domain.Order_Good;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.form.ChangeInfoFormBean;
import ru.kpfu.itis.toyshop.sender.Mailing;
import ru.kpfu.itis.toyshop.service.OrderGoodService;
import ru.kpfu.itis.toyshop.service.OrderService;
import ru.kpfu.itis.toyshop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.smartcardio.ATR;
import javax.validation.Valid;
import java.util.List;

/**
 * Regina
 * 07.04.2016 23:30
 */
@Controller
@RequestMapping("/cabinet")
public class CabinetController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderGoodService orderGoodService;

    private final String ATTR_CHANGE_FORM = "changeForm";

    @IncludeMenuList
    @RequestMapping(method = RequestMethod.GET)
    public String renderCabinetPage() {
        User user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        request.setAttribute("currentUser", user);
        request.setAttribute("orderGoods", orderService.getOrderByUser(user));
        return "cabinet/cabinet";
    }

    @IncludeMenuList
    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String renderRegistrationPage() {
        User user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        ChangeInfoFormBean changeInfoFormBean = new ChangeInfoFormBean();
        changeInfoFormBean.setName(user.getName());
        changeInfoFormBean.setPassword(user.getHash_pass());
        changeInfoFormBean.setConfirmPassword(user.getHash_pass());
        request.setAttribute(ATTR_CHANGE_FORM, changeInfoFormBean);
        return "cabinet/changeInfo";
    }

    @IncludeMenuList
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeInfo(@Valid @ModelAttribute(ATTR_CHANGE_FORM) ChangeInfoFormBean changeInfoFormBean,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !changeInfoFormBean.getPassword().equals(changeInfoFormBean.getConfirmPassword())) {
            request.setAttribute("incorrect", true);
            return "cabinet/changeInfo";
        }
        User user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        user.setName(changeInfoFormBean.getName());
        if (changeInfoFormBean.getPassword() != null) {
            HashMake hashMake = new HashMake();
            user.setHash_pass(hashMake.md5Apache(changeInfoFormBean.getPassword()));
        }
        request.setAttribute("currentUser", user);
        request.setAttribute("orderGoods", orderService.getOrderByUser(user));
        return "cabinet/cabinet";
    }

    @IncludeMenuList
    @RequestMapping(value = "/removeOrder", method = RequestMethod.POST)
    public String removeOrder(Long orderId) {
        User user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        Order order = orderService.getOrderById(orderId);
        orderService.updateOrder(order);
        List<Order_Good> order_goods = orderGoodService.getGoodsByOrder(order);
        String s = "";
        for (Order_Good order_good: order_goods) {
            s += order_good.getGoods().getName() + " " + order_good.getCount() + "шт." + "\n";
        }
        Mailing mailing = new Mailing();
        mailing.sendMail(user.getLogin(), "Order", "Ваш заказ отменен!\n" +  s);
        request.setAttribute("currentUser", user);
        request.setAttribute("orderGoods", orderService.getOrderByUser(user));
        return "cabinet/cabinet";
    }
}
