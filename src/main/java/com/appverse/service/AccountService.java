package com.appverse.service;
 
import java.util.List;
 
import com.appverse.dto.AccountDTO;
 
public interface AccountService {
 
    AccountDTO addAccount(AccountDTO accountDTO);
 
    AccountDTO getAccountById(Long accountId);
 
    List<AccountDTO> getAllAccounts();
 
    AccountDTO updateAccount(Long accountId, AccountDTO accountDTO);
 
    void deleteAccount(Long accountId);
}
 