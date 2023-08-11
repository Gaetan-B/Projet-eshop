package ifapme.tfe.backend.payload;

import ifapme.tfe.backend.constant.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatePayload {
    private UUID account_id;
    private String username;
    private String password;
    private String email;
    private boolean active;
    private UserRole role;
}
