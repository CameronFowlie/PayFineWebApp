package com.example.payfinewebapp.service;

import com.example.payfinewebapp.entity.Fine;
import com.example.payfinewebapp.repository.FineRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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

    public List<Fine> GetAllFines()
    {
        return fineRepo.findAll();
    }

    public Optional<Fine> GetFineById(Long id)
    {
        return fineRepo.findById(id);
    }

    public Optional<Fine> GetFineByReferencePlus(String refCode, String postcode, String houseNo)
    {
        return fineRepo.findByReferenceCodeAndPostcodeAndHouseNo(refCode, postcode, houseNo);
    }

    public Optional<Fine> GetFineByReference(String refCode)
    {
        return fineRepo.findByReferenceCode(refCode);
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
        fine.setHouseNo(fineDetails.getHouseNo());
        return fineRepo.save(fine);
    }
}
