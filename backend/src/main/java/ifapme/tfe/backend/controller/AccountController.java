package ifapme.tfe.backend.controller;

import ifapme.tfe.backend.entity.Account;
import ifapme.tfe.backend.payload.UserCreatePayload;
import ifapme.tfe.backend.payload.UserUpdatePayload;
import ifapme.tfe.backend.payload.response.ApiResponse;
import ifapme.tfe.backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class AccountController {
    private final String BASE_CODE = "api.user.";

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/list")
    public ApiResponse list() {
        return new ApiResponse(true, accountRepository.findAll(), BASE_CODE + "list.success");
    }

    @GetMapping("/detail/{id}")
    public ApiResponse detail(@PathVariable UUID id) {
        return new ApiResponse(true, accountRepository.findById(id), BASE_CODE + "detail.success");
    }

    @PostMapping("/create")
    public ApiResponse create(@RequestBody UserCreatePayload payload) {
        try {
            Account account = new Account.AccountBuilder()
                    .setUsername(payload.getUsername())
                    .setPassword(payload.getPassword())
                    .setEmail(payload.getEmail())
                    .setActive(true)
                    .setRole(payload.getRole()).build();
            Account newAccount = accountRepository.save(account);
            return new ApiResponse(true, newAccount, BASE_CODE + "create.success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(false, null, BASE_CODE + "create.error");
        }
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody UserUpdatePayload payload) {
        try {
            if(accountRepository.findById(payload.getAccount_id()).isPresent()) {
                Account account = new Account.AccountBuilder()
                        .setUsername(payload.getUsername())
                        .setPassword(payload.getPassword())
                        .setEmail(payload.getEmail())
                        .setRole(payload.getRole()).build();
                Account newAccount = accountRepository.save(account);
                return new ApiResponse(true, newAccount, BASE_CODE + "update.success");
            } else {
                return new ApiResponse(true, null, BASE_CODE + "update.error.notfound");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  new ApiResponse(false, null, BASE_CODE + "update.error");
        }
    }

    @PutMapping("/deactivate/{id}")
    public ApiResponse deactivate(@PathVariable UUID id) {
        Account existingAccount = accountRepository.findById(id).orElse(null);
        if (existingAccount != null) {
            existingAccount.setActive(false);
            accountRepository.save(existingAccount);
            return new ApiResponse(true, null, BASE_CODE + "deactivate.success");
        } else {
            return new ApiResponse(false, null, BASE_CODE + "deactivate.error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        Account accountToDelete = accountRepository.findById(id).orElse(null);
        if (accountToDelete != null) {
            accountRepository.delete(accountToDelete);
            return new ApiResponse(true, null, BASE_CODE + "delete.success");
        } else {
            return new ApiResponse(false, null, BASE_CODE + "delete.error");
        }
    }
}
