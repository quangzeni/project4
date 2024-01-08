package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.CustomerAccount;
import ra.service.CustomerAccountService;

import java.util.List;

@Controller
@RequestMapping("/customerAccountController")
public class CustomerAccountController {

    @Autowired
    private CustomerAccountService customerAccountService;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView("customerAccount");
        List<CustomerAccount> listCustomerAccount = customerAccountService.findAll();
        mav.addObject("listCustomerAccount", listCustomerAccount);
        return mav;
    }

//    @PostMapping("/login")
//    public String login()


//    @PostMapping("/lock/{accountId}")
//    public String lockCustomerAccount(@PathVariable Long accountId) {
//        boolean result = customerAccountService.lockCustomerAccount(accountId);
//        if (result) {
//            return "redirect:/customerAccountController/findAll";
//        } else {
//            // Xử lý lỗi khóa tài khoản
//            return "error";
//        }
//    }

//    @PostMapping("/unlock/{accountId}")
//    public String unlockCustomerAccount(@PathVariable Long accountId) {
//        boolean result = customerAccountService.unlockCustomerAccount(accountId);
//        if (result) {
//            return "redirect:/customerAccountController/findAll";
//        } else {
//            // Xử lý lỗi mở khóa tài khoản
//            return "error";
//        }
//    }
}

