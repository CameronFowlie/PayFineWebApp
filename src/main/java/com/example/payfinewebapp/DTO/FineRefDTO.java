package com.example.payfinewebapp.DTO;


import java.time.LocalDate;

public class FineRefDTO
{
    private String referenceCode;

    private String postcode;

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
