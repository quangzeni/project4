package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.*;
import ra.service.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.stream.Collectors;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private CustomerAccountService customerAccountService;

    @GetMapping("/dashboardController")
    public ModelAndView showDashboard() {
        ModelAndView mav = new ModelAndView("dashboard");
        List<Product> productList = productService.findAll();
        int activeProduct = (int) productList.stream().filter(product -> product.isStatus()).count();
        List<Order> orderList = orderService.findAll();
        int cancelOrder = (int) orderList.stream().filter(order -> order.getStatus().equals("Đã hủy")).count();
        int waitingOrder = (int) orderList.stream().filter(order -> order.getStatus().equals("Đã chờ")).count();
        int confirmOrder = (int) orderList.stream().filter(order -> order.getStatus().equals("Đã được duyệt")).count();
        int completeOrder = (int) orderList.stream().filter(order -> order.getStatus().equals("Đã nhận")).count();
        List<CustomerAccount> customerAccountList = customerAccountService.findAll();
        int activeAccount = (int) customerAccountList.stream().filter(customerAccount -> customerAccount.isStatus()).count();

        // Lấy doanh thu ngày và tháng hiện tại
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfCurrentMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate lastDayOfCurrentMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
        List<OrderDetail> orderDetailList = orderDetailService.findAll();

        // Lấy danh sách cácOrder có trong ngày hôm nay
        List<OrderDetail> orderDetailOfToday = orderDetailList.stream().filter(orderDetail -> {
            LocalDate orderDate = orderDetail.getOrder().getCreatedAt().toLocalDate();
            return (orderDate.isEqual(today));}).collect(Collectors.toList());

        // Lấy danh sách cácOrder có trong tháng này
        List<OrderDetail> orderDetailOfMonth = orderDetailList.stream().filter(orderDetail -> {
                    // Lấy thời điê tạo OrderDetail, chuyển đổi thành localdate
            LocalDate orderDate = orderDetail.getOrder().getCreatedAt().toLocalDate();
                    return (orderDate.isEqual(firstDayOfCurrentMonth) || orderDate.isAfter(firstDayOfCurrentMonth))
                            && (orderDate.isEqual(lastDayOfCurrentMonth) || orderDate.isBefore(lastDayOfCurrentMonth
                            .plusDays(1)));
                })
                .collect(Collectors.toList());

        //Chuyển đổi danh sách order sang luồng và lấy dữ liệu total. tinhs tổng
        double todayRevenue = orderDetailOfToday.stream().mapToDouble(OrderDetail::getTotal).sum();

        double totalRevenue = orderDetailOfMonth.stream().mapToDouble(OrderDetail::getTotal).sum();

        mav.addObject("productList", productList);
        mav.addObject("activeProduct", activeProduct);

        mav.addObject("orderList", orderList);
        mav.addObject("cancelOrder", cancelOrder);
        mav.addObject("waitingOrder", waitingOrder);
        mav.addObject("confirmOrder", confirmOrder);
        mav.addObject("completeOrder", completeOrder);

        mav.addObject("customerAccountList", customerAccountList);
        mav.addObject("activeAccount", activeAccount);

        mav.addObject("totalRevenue", totalRevenue);
        mav.addObject("todayRevenue", todayRevenue);
        return mav;
    }
}
