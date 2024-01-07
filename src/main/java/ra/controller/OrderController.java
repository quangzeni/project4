package ra.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Order;
import ra.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/orderController")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView("orders");
        List<Order> listOrder = orderService.findAll();
        mav.addObject("listOrder", listOrder);
        return mav;
    }

//    @PostMapping("/approve/{orderId}")
//    public String approveOrder(@PathVariable Long orderId) {
//        boolean result = orderService.approveOrder(orderId);
//        if (result) {
//            return "redirect:/orderController/findAll";
//        } else {
//            // Xử lý lỗi duyệt đơn hàng
//            return "error";
//        }
//    }

    @PostMapping("/cancel/{orderId}")
    public String cancelOrder(@PathVariable Long orderId) {
        boolean result = orderService.cancelOrder(orderId);
        if (result) {
            return "redirect:/orderController/findAll";
        } else {
            return "error";
        }
    }

//    @GetMapping("/details/{orderId}")
//    public String orderDetails(@PathVariable Long orderId, Model model) {
//        List<OrderDetail> orderDetails = orderService.getOrderDetails(orderId);
//        model.addAttribute("orderDetails", orderDetails);
//        return "orders/details";
//    }
}

