package com.example.payfinewebapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Fine
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String referenceCode;

    private Double amountDue;


    private LocalDate paymentDeadline;

    private String postcode;

    private String houseNo;

    public Fine()
    {

    }

    public Fine(String referenceCode, Double amountDue, LocalDate paymentDeadline, String postcode, String houseNo)
    {
        this.amountDue = amountDue;
        this.referenceCode = referenceCode;
        this.paymentDeadline = paymentDeadline;
        this.postcode = postcode;
        this.houseNo = houseNo;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Double getAmountDue()
    {
        return amountDue;
    }

    public void setAmountDue(Double amountDue)
    {
        this.amountDue = amountDue;
    }

    public String getReferenceCode()
    {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode)
    {
        this.referenceCode = referenceCode;
    }

    public LocalDate getPaymentDeadline()
    {
        return paymentDeadline;
    }

    public void setPaymentDeadline(LocalDate paymentDeadline)
    {
        this.paymentDeadline = paymentDeadline;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getHouseNo()
    {
        return houseNo;
    }

    public void setHouseNo(String houseNo)
    {
        this.houseNo = houseNo;
    }
}
