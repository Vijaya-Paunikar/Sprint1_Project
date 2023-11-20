package com.example.controller;

import com.example.model.Billing;
import com.example.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/billings")
public class BillingController 
{

    @Autowired
    private BillingRepository billingRepository;

    @GetMapping("/getBills")
    public List<Billing> getAllBillings() 
    {
        return billingRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billing> getBillingById(@PathVariable Long id) 
    {
        Optional<Billing> billing = billingRepository.findById(id);
        return billing.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/generateBill")
    public ResponseEntity<String> addBilling(@RequestBody Billing billing) {
        billingRepository.save(billing);
        return new ResponseEntity<>("Billing generated Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBilling(@PathVariable Long id, @RequestBody Billing updatedBilling) {
        Optional<Billing> billing = billingRepository.findById(id);
        if (billing.isPresent()) {
            Billing existingBilling = billing.get();
            // Update the billing details
            existingBilling.setCustomerId(updatedBilling.getCustomerId());
            existingBilling.setServiceId(updatedBilling.getServiceId());
            existingBilling.setCost(updatedBilling.getCost());
            existingBilling.setInvoiceStatus(updatedBilling.getInvoiceStatus());
            existingBilling.setPaymentStatus(updatedBilling.getPaymentStatus());
            existingBilling.setPaymentDueDate(updatedBilling.getPaymentDueDate());
            existingBilling.setPaymentMethod(updatedBilling.getPaymentMethod());

            billingRepository.save(existingBilling);
            return new ResponseEntity<>("Billing details updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Billing not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBilling(@PathVariable Long id) {
        Optional<Billing> billing = billingRepository.findById(id);
        if (billing.isPresent()) {
            billingRepository.deleteById(id);
            return new ResponseEntity<>("Billing deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Billing not found", HttpStatus.NOT_FOUND);
        }
    }
}

