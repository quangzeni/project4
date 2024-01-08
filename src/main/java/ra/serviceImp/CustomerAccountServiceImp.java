package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.model.CustomerAccount;
import ra.repository.CustomerAccountRepository;
import ra.service.CustomerAccountService;

import java.util.List;

@Service
public class CustomerAccountServiceImp implements CustomerAccountService {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Override
    public List<CustomerAccount> findAll() {
        return customerAccountRepository.findAll();
    }

    @Override
    public CustomerAccount findById(Long accountId) {
        return customerAccountRepository.findById(accountId).orElse(null);
    }

    @Override
    public CustomerAccount login(String email, String password) {
        CustomerAccount customerAccount = customerAccountRepository.findByEmail(email);
        if ((customerAccount != null) && customerAccount.getPassword().equals(password)) {
            return customerAccount;
        }
        return null;
    }

    @Override
    @Transactional
    public boolean save(CustomerAccount customerAccount) {
        CustomerAccount customerAccountNew = customerAccountRepository.save(customerAccount);
        return customerAccountNew != null ? true : false;
    }




    @Override
    @Transactional
    public boolean update(CustomerAccount customerAccountUpdate) {
        boolean result = false;
        try {
            CustomerAccount exitingCustomerAccount = customerAccountRepository.findById(customerAccountUpdate.getId()).orElse(null);
            if (exitingCustomerAccount != null){
                exitingCustomerAccount.setEmail(customerAccountUpdate.getEmail());
                exitingCustomerAccount.setPassword(customerAccountUpdate.getPassword());
                exitingCustomerAccount.setCreatedAt(customerAccountUpdate.getCreatedAt());
                exitingCustomerAccount.setRole(customerAccountUpdate.getRole());
                exitingCustomerAccount.setStatus(customerAccountUpdate.isStatus());
                customerAccountRepository.save(exitingCustomerAccount);
                result = true;
            }else {
                result = false;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public boolean delete(Long accountId) {
        boolean result = false;
        try {
            customerAccountRepository.deleteById(accountId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}

