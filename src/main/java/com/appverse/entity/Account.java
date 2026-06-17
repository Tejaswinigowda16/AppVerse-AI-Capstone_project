package com.appverse.entity;
 
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
public class Account {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
 
    private String accountNumber;
 
    private String accountType;
 
    private double balance;
 
    private String accountStatus;
 
    @ManyToOne
    private User user;
}
 