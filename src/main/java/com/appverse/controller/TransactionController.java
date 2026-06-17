package com.appverse.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.appverse.dto.TransactionDTO;
import com.appverse.service.TransactionService;
 
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
 
    @Autowired
    private TransactionService transactionService;
 
    @PostMapping
    public String addTransaction(@RequestBody TransactionDTO transactionDTO) {
 
        transactionService.addTransaction(transactionDTO);
 
        return "Transaction Added Successfully";
    }
 
    @GetMapping("/{id}")
    public TransactionDTO getTransactionById(@PathVariable Long id) {
 
        return transactionService.getTransactionById(id);
    }
 
    @GetMapping
    public List<TransactionDTO> getAllTransactions() {
 
        return transactionService.getAllTransactions();
    }
 
    @PutMapping("/{id}")
    public TransactionDTO updateTransaction(@PathVariable Long id,
                                            @RequestBody TransactionDTO transactionDTO) {
 
        return transactionService.updateTransaction(id, transactionDTO);
    }
 
    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
 
        transactionService.deleteTransaction(id);
 
        return "Transaction Deleted Successfully";
    }
}
 