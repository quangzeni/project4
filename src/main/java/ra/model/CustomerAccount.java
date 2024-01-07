package ra.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

//    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
//    private UserRole role;
    private String role;

    @Column(name = "status")
    private boolean status;

}
