package ra.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Category;
import ra.model.Product;
import ra.service.CategoryService;
import ra.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView("products");
        List<Product> productList = productService.findAll();
        mav.addObject("productList", productList);
        return mav;
    }

    @GetMapping("/newProduct")
    public String showNewProductPage(Model model){
        List<Category> listCategories = categoryService.findAll();
        model.addAttribute("listCategories",listCategories);
        return "newProduct";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") Product productNew,
                                @RequestParam("avatar") MultipartFile avatar,
                                @RequestParam("otherImages") MultipartFile[] otherImages) {
        boolean result = productService.save(productNew, avatar, otherImages);
        if (result) {
            return "redirect:/productController/findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/initUpdate/{id}")
    public String initUpdate(@PathVariable String id, Model model) {
        Product productUpdate = productService.findById(id);
        model.addAttribute("productUpdate", productUpdate);
        return "editProduct";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("productUpdate") Product productUpdate) {
        boolean result = productService.update(productUpdate);
        if (result) {
            return "redirect:/productController/findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        boolean result = productService.delete(id);
        if (result) {
            return "redirect:/productController/findAll";
        } else {
            return "error";
        }
    }
    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam("searchInput") String searchInput) {
        List<Product> searchResults = productService.searchByName(searchInput);
        ModelAndView mav = new ModelAndView("products");
        mav.addObject("productList", searchResults);
        return mav;
    }

    @GetMapping("/sortByName")
    public ModelAndView sortByName(@RequestParam("sortSelect") String sortValue){
        List<Product> sortedCategories = productService.sortByName(sortValue);
        ModelAndView mav = new ModelAndView("products");
        mav.addObject("productList", sortedCategories);
        return mav;
    }
}
