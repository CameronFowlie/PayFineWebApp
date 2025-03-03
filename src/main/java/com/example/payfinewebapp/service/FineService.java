package com.example.payfinewebapp.service;

import com.example.payfinewebapp.entity.Fine;
import com.example.payfinewebapp.repository.FineRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FineService
{
    @Autowired
    private FineRepository fineRepo;

    public Fine CreateFine(Fine fine)
    {
        return fineRepo.save(fine);
    }

    public Optional<Fine> GetFineByReference(String refCode, String postcode, String houseNo)
    {
        return fineRepo.findByReferenceCodeAndPostcodeAndHouseNo(refCode, postcode, houseNo);
    }

    public void DeleteFine(Long id)
    {
        fineRepo.deleteById(id);
    }

    public Fine UpdateFine(Long id, Fine fineDetails)
    {
        Fine fine = fineRepo.findById(id).orElseThrow();
        fine.setAmountDue(fineDetails.getAmountDue());
        fine.setReferenceCode(fineDetails.getReferenceCode());
        fine.setPaymentDeadline(fineDetails.getPaymentDeadline());
        fine.setPostcode(fineDetails.getPostcode());
        fine.setHouseNo(fineDetails.getPostcode());
        return fineRepo.save(fine);
    }


}
