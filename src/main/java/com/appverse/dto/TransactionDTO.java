package com.appverse.dto;
 
import java.time.LocalDate;
 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
 
    private Long transactionId;
 
    @NotBlank(message = "Transaction Type is required")
    private String transactionType;
 
    @Positive(message = "Amount must be greater than zero")
    private double amount;
 
    private LocalDate transactionDate;
 
    @NotBlank(message = "Status is required")
    private String status;
 
    private Long accountId;
    
    public String getTransactionType() {
        return transactionType;
    }
     
    public double getAmount() {
        return amount;
    }
     
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
     
    public String getStatus() {
        return status;
    }
    
    public Long getTransactionId() {
        return transactionId;
    }
     
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
     
    public void setAmount(double amount) {
        this.amount = amount;
    }
     
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
     
    public void setStatus(String status) {
        this.status = status;
    }
     
}
 