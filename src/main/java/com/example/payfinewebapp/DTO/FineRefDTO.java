package com.example.payfinewebapp.DTO;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.CreditCardNumber;
import jakarta.validation.constraints.Pattern;

public class FineRefDTO
{
    private String referenceCode;

    @Pattern(regexp = "^[A-Za-z]{1,2}[0-9Rr][0-9A-Za-z]? [0-9][ABD-HJLNP-UW-Zabd-hjlnp-uw-z]{2}$", message = "Not a valid UK post code")
    private String postcode;

    @Pattern(regexp = "^[0-9]{1,2}[A-Za-z]?$", message = "Not a valid house number")
    private String houseNo;

    public FineRefDTO()
    {

    }

    public FineRefDTO(String referenceCode, String postcode, String houseNo)
    {
        this.referenceCode = referenceCode;
        this.postcode = postcode;
        this.houseNo = houseNo;
    }

    public String getReferenceCode()
    {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode)
    {
        this.referenceCode = referenceCode;
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
