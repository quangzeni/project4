package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Category;
import ra.service.CategoryService;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/dashboardController")
    public ModelAndView showDashboard() {
        ModelAndView mav = new ModelAndView("dashboard");
        List<Category> listCategories = categoryService.findAll();
        mav.addObject("listCategories", listCategories);
        return mav;
    }
}
