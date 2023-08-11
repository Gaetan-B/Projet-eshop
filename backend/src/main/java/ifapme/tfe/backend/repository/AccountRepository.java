package ifapme.tfe.backend.repository;

import ifapme.tfe.backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    Account findByUsername(String username);
}
