package com.example.payfinewebapp.web;

import com.example.payfinewebapp.DTO.FineRefDTO;
import com.example.payfinewebapp.DTO.PaymentDTO;
import com.example.payfinewebapp.entity.Fine;
import com.example.payfinewebapp.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        String test = "RCode " + finerefdto.getReferenceCode() + " Postcode: " + finerefdto.getPostcode() + " House No: " + finerefdto.getHouseNo();
        System.out.println(test);
        return "redirect:/paycourtfine/paymentscreen/" + finerefdto.getReferenceCode();
    }

    @GetMapping("paymentscreen/{ref}")
    public String PayFine(@PathVariable String ref, Model model)
    {
        Optional<Fine> fine = fineService.GetFineByReference(ref);
        model.addAttribute("fine", fine.get());
        model.addAttribute("paymentdto", new PaymentDTO());
        return "paymentScreen";
    }

    @PostMapping("paymentscreen")
    public String FindFine(@ModelAttribute PaymentDTO paymentdto)
    {
        String test = "Card Num " + paymentdto.getCardNumber() + " Amount: " + paymentdto.getAmountToPay() + " CVC: " + paymentdto.getCvcNumber();
        System.out.println(test);
        return "redirect:/paycourtfine/paymentconfirmationscreen";
    }

    @GetMapping("paymentconfirmationscreen")
    public String ConfirmFine()
    {
        return "paymentConfirmationScreen";
    }
}
