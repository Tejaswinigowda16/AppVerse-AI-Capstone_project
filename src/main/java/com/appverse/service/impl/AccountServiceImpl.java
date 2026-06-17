package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.appverse.dto.AccountDTO;
import com.appverse.entity.Account;
import com.appverse.repository.AccountRepository;
import com.appverse.service.AccountService;
 
@Service
public class AccountServiceImpl implements AccountService {
 
    @Autowired
    private AccountRepository accountRepository;
 
    @Override
    public AccountDTO addAccount(AccountDTO accountDTO) {
 
        Account account = new Account();
 
        BeanUtils.copyProperties(accountDTO, account);
 
        Account savedAccount = accountRepository.save(account);
 
        AccountDTO savedAccountDTO = new AccountDTO();
 
        BeanUtils.copyProperties(savedAccount, savedAccountDTO);
 
        return savedAccountDTO;
    }
 
    @Override
    public AccountDTO getAccountById(Long accountId) {
 
        return new AccountDTO();
    }
 
    @Override
    public List<AccountDTO> getAllAccounts() {
 
        return new ArrayList<>();
    }
 
    @Override
    public AccountDTO updateAccount(Long accountId, AccountDTO accountDTO) {
 
        return new AccountDTO();
    }
 
    @Override
    public void deleteAccount(Long accountId) {
 
    }
}
 