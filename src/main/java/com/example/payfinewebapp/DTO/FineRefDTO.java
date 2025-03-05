package com.example.payfinewebapp.DTO;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.CreditCardNumber;
import jakarta.validation.constraints.Pattern;

public class FineRefDTO
{
    private String referenceCode;

    @Pattern(regexp = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$", message = "Not a valid UK post code")
    private String postcode;

    @Pattern(regexp = "^[0-9]{1,2}[A-Z]$", message = "Not a valid house number")
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
