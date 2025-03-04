package com.example.payfinewebapp.controller;

import com.example.payfinewebapp.entity.Fine;
import com.example.payfinewebapp.repository.FineRepository;
import com.example.payfinewebapp.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/fines")
public class FineController
{
    @Autowired
    private FineService fineService;
    @Autowired
    private FineRepository fineRepo;

    Boolean test = false;

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
        if (!test)
        {
            Fine f1 = new Fine("feiwfgw1", 1000.0, LocalDate.of(2020, 1, 8), "BT65 7HU", "23A");
            Fine f2 = new Fine("feiwfgw2", 1000.0, LocalDate.of(2020, 1, 8), "BT65 7HU", "23A");
            Fine f3 = new Fine("feiwfgw3", 1000.0, LocalDate.of(2020, 1, 8), "BT65 7HU", "23A");

            CreateFine(f1);
            CreateFine(f2);
            CreateFine(f3);
            test = true;
        }
        return fineService.GetAllFines();
    }

    @GetMapping("/search")
    public ResponseEntity<Fine> GetFineByRef(@RequestBody Map<String, String> _fine)
    {
        //String test = "RCode " + _fine.get("referenceCode") + " Postcode: " + _fine.get("postcode") + " House No: " + _fine.get("houseNo");

        Fine fine = fineService.GetFineByReference(_fine.get("referenceCode"), _fine.get("postcode"), _fine.get("houseNo")).orElseThrow();

        return ResponseEntity.ok(fine);
        //Fine fine = fineService.GetFineById(id).orElseThrow();
        //return ResponseEntity.ok(fine);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fine> GetFineByID(@PathVariable Long id)
    {
        Fine fine = fineService.GetFineById(id).orElseThrow();
        return ResponseEntity.ok(fine);
    }

    @PutMapping("/{id}")
    public Fine UpdateFine(@PathVariable Long id, @RequestBody Fine fine)
    {
        return fineService.UpdateFine(id, fine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteFine(@PathVariable Long id)
    {
        fineService.DeleteFine(id);
        return ResponseEntity.noContent().build();
    }
}
