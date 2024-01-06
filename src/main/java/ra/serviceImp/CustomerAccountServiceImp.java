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
    @Transactional
    public boolean createCustomerAccount(CustomerAccount customerAccount) {
        // Logic để tạo tài khoản khách hàng
        return true;
    }

    @Override
    @Transactional
    public boolean updateCustomerAccount(CustomerAccount customerAccount) {
        // Logic để cập nhật thông tin tài khoản khách hàng
        return true;
    }

    @Override
    @Transactional
    public boolean deleteCustomerAccount(Long accountId) {
        // Logic để xóa tài khoản khách hàng
        return true;
    }
}

