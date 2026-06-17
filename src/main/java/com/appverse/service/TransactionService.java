package com.appverse.service;
 
import java.util.List;
 
import com.appverse.dto.TransactionDTO;
 
public interface TransactionService {
 
    TransactionDTO addTransaction(TransactionDTO transactionDTO);
 
    TransactionDTO getTransactionById(Long transactionId);
 
    List<TransactionDTO> getAllTransactions();
 
    TransactionDTO updateTransaction(Long transactionId,
                                     TransactionDTO transactionDTO);
 
    void deleteTransaction(Long transactionId);
}
 