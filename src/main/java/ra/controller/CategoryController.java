package ra.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Category;
import ra.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/categoryController")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView("category");
        List<Category> listCategories = categoryService.findAll();
        mav.addObject("listCategories", listCategories);
        return mav;
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute("category") Category categoryNew) {
        boolean result = categoryService.save(categoryNew);
        if (result) {
            return "redirect:/categoryController/findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/initUpdate/{id}")
    public String initUpdate(@PathVariable Long id, Model model) {
        Category categoryUpdate = categoryService.findById(id);
        model.addAttribute("categoryUpdate", categoryUpdate);
        return "editCategory";
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute("categoryUpdate") Category categoryUpdate) {
        boolean result = categoryService.update(categoryUpdate);
        if (result) {
            return "redirect:/categoryController/findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        boolean result = categoryService.delete(id);
        if (result) {
            return "redirect:/categoryController/findAll";
        } else {
            return "error";
        }
    }
}

