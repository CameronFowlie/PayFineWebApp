package com.example.payfinewebapp.web;

import com.example.payfinewebapp.DTO.FineRefDTO;
import com.example.payfinewebapp.DTO.PaymentDTO;
import com.example.payfinewebapp.entity.Fine;
import com.example.payfinewebapp.service.FineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("paycourtfine")
public class FineWeb {


    @Autowired
    private FineService fineService;

    Boolean test = false;

    @GetMapping
    public String HomePage(Model model) {
        if (!test) {
            Fine f1 = new Fine("feiwfgw1", 1000.0, LocalDate.of(2020, 1, 8), "BT65 7HU", "23A");
            Fine f2 = new Fine("feiwfgw2", 1000.0, LocalDate.of(2020, 1, 8), "BT65 7HU", "23A");
            Fine f3 = new Fine("feiwfgw3", 1000.0, LocalDate.of(2020, 1, 8), "BT65 7HU", "23A");
            Fine f4 = new Fine("4", 100.0, LocalDate.of(2020, 1, 8), "4", "4");

            fineService.CreateFine(f1);
            fineService.CreateFine(f2);
            fineService.CreateFine(f3);
            fineService.CreateFine(f4);
            test = true;
        }
        model.addAttribute("title", "Pay a court fine");
        return "indexGov";
    }

    @GetMapping("payonlineenterdetails")
    public String FindFine(Model model) {
        model.addAttribute("title", "Enter details");
        model.addAttribute("finerefdto", new FineRefDTO());
        return "enterDetails";
    }
    @PostMapping
    public String FindFine(@Valid @ModelAttribute FineRefDTO finerefdto, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            for(ObjectError error : result.getAllErrors())
            {
                if(Objects.requireNonNull(error.getDefaultMessage()).contains("house"))
                {
                    model.addAttribute("houseError", "Not a valid house number");
                }
                else if(error.getDefaultMessage().contains("post"))
                {
                    model.addAttribute("postError", "Not a valid UK post code");
                }
            }
            if(fineService.GetFineByReference(finerefdto.getReferenceCode()).isEmpty())
            {
                model.addAttribute("refError", "Reference number not valid");
            }
            model.addAttribute("title", "Enter details");
            model.addAttribute("error", "No Fine found, Please Check entered details");
            model.addAttribute("finerefdto", finerefdto);
            return "enterDetails";
        }

        Optional<Fine> fine = fineService.GetFineByReferencePlus(finerefdto.getReferenceCode(),finerefdto.getPostcode(),finerefdto.getHouseNo());
        if(fine.isEmpty())
        {
            model.addAttribute("title", "Enter details");
            model.addAttribute("error", "No Fine found, Please Check entered details");
            model.addAttribute("finerefdto", finerefdto);

            return "enterDetails";
        }
        return "redirect:/paycourtfine/paymentscreen/" + finerefdto.getReferenceCode();
    }

    @GetMapping("paymentscreen/{ref}")
    public String PayFine(@PathVariable String ref, Model model) {
        Optional<Fine> fine = fineService.GetFineByReference(ref);
        model.addAttribute("title", "Payment details");
        model.addAttribute("fine", fine.get());
        model.addAttribute("paymentdto", new PaymentDTO());
        return "paymentScreen";
    }
    @PostMapping("paymentscreen/{ref}")
    public String FindFine(@Valid @ModelAttribute PaymentDTO paymentdto, BindingResult result,@PathVariable String ref, Model model)
    {
        if(result.hasErrors())
        {
            for(ObjectError error : result.getAllErrors())
            {
                if (Objects.requireNonNull(error.getDefaultMessage()).contains("card"))
                {
                    model.addAttribute("creditError", "Credit card number is invalid");
                }
                else if (error.getDefaultMessage().contains("CVC"))
                {
                    model.addAttribute("cvcError", "CVC number is invalid");
                }
                else if (error.getDefaultMessage().contains("Payed"))
                {
                    model.addAttribute("amountError", "Payed amount must be more than 0");
                }
            }
            model.addAttribute("Error", "Invalid Payment Details");
            model.addAttribute("title", "Payment details");
            Optional<Fine> fine = fineService.GetFineByReference(ref);
            model.addAttribute("fine", fine.get());
            model.addAttribute("paymentdto", paymentdto);
            return "paymentscreen";
        }
        String test = "Card Num " + paymentdto.getCardNumber() + " Amount: " + paymentdto.getAmountToPay() + " CVC: " + paymentdto.getCvcNumber();

        Fine fine = fineService.PayFine(ref, paymentdto);
        if(fine == null)
        {
            return "fineSettled";
        }
        else
        {
            return "redirect:/paycourtfine/paymentconfirmationscreen/" + ref;
        }
    }

    @GetMapping("paymentconfirmationscreen/{ref}")
    public String ConfirmFine(@PathVariable String ref, Model model) {
        Optional<Fine> fine = fineService.GetFineByReference(ref);
        model.addAttribute("title", "Payment confirmed");
        model.addAttribute("fine", fine.get());
        return "paymentConfirmationScreen";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //update fine based on amount input
    //if fine - input < 0 then say fine payed
    //else show remaining balance
    //ask vivek about error handling
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
}
