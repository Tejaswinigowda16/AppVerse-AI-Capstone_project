package com.appverse.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.appverse.dto.AccountDTO;
import com.appverse.service.AccountService;
 
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
 
    @Autowired
    private AccountService accountService;
 
    @PostMapping
    public String addAccount(@RequestBody AccountDTO accountDTO) {
 
        accountService.addAccount(accountDTO);
 
        return "Account Added Successfully";
    }
 
    @GetMapping("/{id}")
    public AccountDTO getAccountById(@PathVariable Long id) {
 
        return accountService.getAccountById(id);
    }
 
    @GetMapping
    public List<AccountDTO> getAllAccounts() {
 
        return accountService.getAllAccounts();
    }
 
    @PutMapping("/{id}")
    public AccountDTO updateAccount(@PathVariable Long id,
                                    @RequestBody AccountDTO accountDTO) {
 
        return accountService.updateAccount(id, accountDTO);
    }
 
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
 
        accountService.deleteAccount(id);
 
        return "Account Deleted Successfully";
    }
}
 