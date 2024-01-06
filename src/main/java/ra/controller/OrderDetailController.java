package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.OrderDetail;
import ra.service.OrderDetailService;

import java.util.List;

@Controller
@RequestMapping("/orderDetailController")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView("orderDetails");
        List<OrderDetail> orderDetailList = orderDetailService.findAll();
        mav.addObject("orderDetailList", orderDetailList);
        return mav;
    }
}
