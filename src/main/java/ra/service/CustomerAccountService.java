package ra.service;

import ra.model.CustomerAccount;

import java.util.List;

public interface CustomerAccountService {
    List<CustomerAccount> findAll();

    CustomerAccount findById(Long accountId);

    boolean save(CustomerAccount customerAccount);

    boolean update(CustomerAccount customerAccount);

    boolean delete(Long accountId);
}

