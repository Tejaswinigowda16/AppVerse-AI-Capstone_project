package com.appverse.dto;
 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
 
    private Long accountId;
 
    @NotBlank(message = "Account Number is required")
    private String accountNumber;
 
    @NotBlank(message = "Account Type is required")
    private String accountType;
 
    @PositiveOrZero(message = "Balance cannot be negative")
    private double balance;
 
    @NotBlank(message = "Account Status is required")
    private String accountStatus;
 
    private Long userId;
}
 