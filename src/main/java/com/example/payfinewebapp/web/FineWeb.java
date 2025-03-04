package com.example.payfinewebapp.web;

import com.example.payfinewebapp.entity.Fine;
import com.example.payfinewebapp.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fines")
public class FineWeb
{
    @Autowired
    private FineService fineService;

    @GetMapping
    public String HomePage()
    {
        return "index";
    }

    @GetMapping("find")
    public String ViewFine()
    {
        return "find-fine";
    }

    @GetMapping("view/{id}")
    public String PayFine(@PathVariable Long id)
    {
        return "pay-fine";
    }
}
