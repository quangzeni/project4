package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.CustomerAccount;

import java.util.Optional;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
    //Optional<CustomerAccount> findByEmailAndPassword(String email,String password);
    CustomerAccount findByEmail(String email);
}

