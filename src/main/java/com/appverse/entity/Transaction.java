package com.appverse.entity;
 
import java.time.LocalDate;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
 
    private String transactionType;
 
    private double amount;
 
    private LocalDate transactionDate;
 
    private String status;
 
    @ManyToOne
    private Account account;
    
    public String getTransactionType() {
        return transactionType;
    }
     
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
     
    public double getAmount() {
        return amount;
    }
     
    public void setAmount(double amount) {
        this.amount = amount;
    }
     
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
     
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
     
    public String getStatus() {
        return status;
    }
     
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Long getTransactionId() {
        return transactionId;
    }
     
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
 