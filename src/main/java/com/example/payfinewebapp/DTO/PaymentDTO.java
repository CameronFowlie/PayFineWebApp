package com.example.payfinewebapp.DTO;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.CreditCardNumber;
public class PaymentDTO
{
    //private String referenceCode;

    private Double amountToPay;

    @CreditCardNumber(message = "Credit card number is invalid")
    private String cardNumber;

    @Size(min = 3, max = 3, message = "CVC number is invalid")
    private String cvcNumber;

    private String expiryDate;

    public PaymentDTO()
    {

    }

    public PaymentDTO(Double amountToPay, String cardNumber, String cvcNumber, String expiryDate)
    {
        this.amountToPay = amountToPay;
        this.cardNumber = cardNumber;
        this.cvcNumber = cvcNumber;
        this.expiryDate = expiryDate;
    }

    public Double getAmountToPay()
    {
        return amountToPay;
    }

    public void setAmountToPay(Double amountToPay)
    {
        this.amountToPay = amountToPay;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public String getCvcNumber()
    {
        return cvcNumber;
    }

    public void setCvcNumber(String cvcNumber)
    {
        this.cvcNumber = cvcNumber;
    }

    public String getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate)
    {
        this.expiryDate = expiryDate;
    }
}
