package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.CustomerAccount;
import ra.service.CustomerAccountService;

@Controller
@RequestMapping(value = "/loginController")
public class LoginController {
    @Autowired
    private CustomerAccountService customerAccountService;
    @GetMapping(value = "/findAll")
    public ModelAndView loginView(){
        ModelAndView mav = new ModelAndView("/login");
        return mav;
    }
    @PostMapping(value ="/loginAdmin")
    public String loginAdmin(String email, String password){
        CustomerAccount loggedInAccount = customerAccountService.login(email, password);

        if (loggedInAccount != null) {
            if (loggedInAccount.getRole().equals("admin")){
                return "redirect:/dashboardController";
            }else {
                return "/userPage";
            }

        }

        return "error";
    }
}
