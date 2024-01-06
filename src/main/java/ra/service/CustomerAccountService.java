package ra.service;

import ra.model.CustomerAccount;

import java.util.List;

public interface CustomerAccountService {
    List<CustomerAccount> findAll();

    CustomerAccount findById(Long accountId);

    boolean createCustomerAccount(CustomerAccount customerAccount);

    boolean updateCustomerAccount(CustomerAccount customerAccount);

    boolean deleteCustomerAccount(Long accountId);
}

