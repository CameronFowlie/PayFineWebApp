package com.example.payfinewebapp.controller;

import com.example.payfinewebapp.entity.Fine;
import com.example.payfinewebapp.repository.FineRepository;
import com.example.payfinewebapp.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/fines")
public class FineController
{
    @Autowired
    private FineService fineService;
    @Autowired
    private FineRepository fineRepo;

    @PostMapping
    public ResponseEntity<Fine> CreateFine(@RequestBody Fine _fine)
    {
        Fine fine = new Fine();
        fine.setReferenceCode(_fine.getReferenceCode());
        fine.setAmountDue(_fine.getAmountDue());
        fine.setPaymentDeadline(_fine.getPaymentDeadline());
        fine.setPostcode(_fine.getPostcode());
        fine.setHouseNo(_fine.getHouseNo());

        Fine savedFine = fineRepo.save(fine);
        return ResponseEntity.ok(savedFine);
    }

    /// ///////PROBABLY DELETE LATER/////////////////////////////////////////////////////////
    @GetMapping
    public List<Fine> getAllFines()
    {
        //return fil
        return null;
    }
}
