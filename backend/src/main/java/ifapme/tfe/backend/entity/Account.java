package ifapme.tfe.backend.entity;

import ifapme.tfe.backend.constant.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "account_id", updatable = false, nullable = false)
    private UUID account_id;

    private String username;
    private String password;
    private String email;
    private boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name ="userRole")
    private UserRole role;

    public static class AccountBuilder {
        UUID account_id;
        String username;
        String password;
        String email;
        boolean active;
        UserRole role;

        public AccountBuilder setAccount_id(UUID account_id) {
            this.account_id = account_id;
            return this;
        }

        public AccountBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public AccountBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder setActive(boolean active) {
            this.active = active;
            return this;
        }

        public AccountBuilder setRole(UserRole role) {
            this.role = role;
            return this;
        }

        public Account build() { return new Account(account_id, username, password, email, active, role); }
    }
}
