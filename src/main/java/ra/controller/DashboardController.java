package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Category;
import ra.model.CustomerAccount;
import ra.model.Order;
import ra.model.Product;
import ra.service.CategoryService;
import ra.service.CustomerAccountService;
import ra.service.OrderService;
import ra.service.ProductService;

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
    private CustomerAccountService customerAccountService;

    @GetMapping("/dashboardController")
    public ModelAndView showDashboard() {
        ModelAndView mav = new ModelAndView("dashboard");
        List<Category> listCategories = categoryService.findAll();
        List<Product> productList = productService.findAll();
        int activeProduct = (int) productList.stream().filter(product -> product.isStatus()).count();
        List<Order> orderList = orderService.findAll();
        List<CustomerAccount> customerAccountList = customerAccountService.findAll();
        mav.addObject("listCategories", listCategories);
        mav.addObject("productList", productList);
        mav.addObject("activeProduct",activeProduct);
        mav.addObject("orderList", orderList);
        mav.addObject("customerAccountList", customerAccountList);
        return mav;
    }
}
