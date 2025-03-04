package com.example.payfinewebapp.web;

import com.example.payfinewebapp.DTO.FineRefDTO;
import com.example.payfinewebapp.entity.Fine;
import com.example.payfinewebapp.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("paycourtfine")
public class FineWeb
{
    @Autowired
    private FineService fineService;

    @GetMapping
    public String HomePage()
    {
        return "index";
    }

    @GetMapping("payonlineenterdetails")
    public String FindFine(Model model)
    {
        model.addAttribute("finerefdto", new FineRefDTO());
        return "enterDetails";
    }

    @PostMapping
    public String FindFine(@ModelAttribute FineRefDTO finerefdto)
    {
        return "redirect:/paycourtfine/paymentscreen";
    }


    @GetMapping("paymentscreen")
    public String PayFine()
    {
        return "paymentScreen";
    }

    @GetMapping("paymentconfirmationscreen")
    public String ConfirmFine()
    {
        return "paymentConfirmationScreen";
    }
}
