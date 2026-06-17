package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.appverse.dto.TransactionDTO;
import com.appverse.entity.Transaction;
import com.appverse.repository.TransactionRepository;
import com.appverse.service.TransactionService;
 
@Service
public class TransactionServiceImpl implements TransactionService {
 
    @Autowired
    private TransactionRepository transactionRepository;
 
    @Override
    public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
 
        Transaction transaction = new Transaction();
 
        BeanUtils.copyProperties(transactionDTO, transaction);
 
        Transaction savedTransaction = transactionRepository.save(transaction);
 
        TransactionDTO savedTransactionDTO = new TransactionDTO();
 
        BeanUtils.copyProperties(savedTransaction, savedTransactionDTO);
 
        return savedTransactionDTO;
    }
 
    @Override
    public TransactionDTO getTransactionById(Long transactionId) {
 
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
 
        TransactionDTO transactionDTO = new TransactionDTO();
 
        transactionDTO.setTransactionId(transaction.getTransactionId());
        transactionDTO.setTransactionType(transaction.getTransactionType());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setTransactionDate(transaction.getTransactionDate());
        transactionDTO.setStatus(transaction.getStatus());
 
        return transactionDTO;
    }
 
    @Override
    public List<TransactionDTO> getAllTransactions() {
 
        List<Transaction> transactions = transactionRepository.findAll();
 
        List<TransactionDTO> transactionDTOList = new ArrayList<>();
 
        for (Transaction transaction : transactions) {
 
            TransactionDTO dto = new TransactionDTO();
 
            dto.setTransactionId(transaction.getTransactionId());
            dto.setTransactionType(transaction.getTransactionType());
            dto.setAmount(transaction.getAmount());
            dto.setTransactionDate(transaction.getTransactionDate());
            dto.setStatus(transaction.getStatus());
 
            transactionDTOList.add(dto);
        }
 
        return transactionDTOList;
    }
 
    @Override
    public TransactionDTO updateTransaction(Long transactionId,
            TransactionDTO transactionDTO) {
 
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
 
        transaction.setTransactionType(transactionDTO.getTransactionType());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setTransactionDate(transactionDTO.getTransactionDate());
        transaction.setStatus(transactionDTO.getStatus());
 
        Transaction updatedTransaction = transactionRepository.save(transaction);
 
        TransactionDTO updatedDTO = new TransactionDTO();
 
        BeanUtils.copyProperties(updatedTransaction, updatedDTO);
 
        return updatedDTO;
    }
 
    @Override
    public void deleteTransaction(Long transactionId) {
 
        transactionRepository.deleteById(transactionId);
    }
}
 