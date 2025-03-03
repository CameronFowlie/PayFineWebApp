package com.example.payfinewebapp.service;

import com.example.payfinewebapp.entity.Fine;
import com.example.payfinewebapp.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /*public Optional<Fine> getFineByReference(String refCode)
    {
        return fineRepo.find
    }*/
}
