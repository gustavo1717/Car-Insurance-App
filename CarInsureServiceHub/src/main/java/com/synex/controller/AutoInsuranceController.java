package com.synex.controller;

import com.synex.domain.AutoInsurance;
import com.synex.service.AutoInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8282")
@RestController
@RequestMapping("/autoInsurance")
public class AutoInsuranceController {

    @Autowired
    private AutoInsuranceService autoInsuranceService;

    @GetMapping("/{autoInsuranceId}")
    public Optional<AutoInsurance> getAutoInsuranceById(@PathVariable Long autoInsuranceId) {
        return autoInsuranceService.getAutoInsuranceById(autoInsuranceId);
    }

    @GetMapping
    public List<AutoInsurance> getAllAutoInsurance() {
        return autoInsuranceService.getAllAutoInsurance();
    }

    @PostMapping("/saveAutoInsurance")
    public AutoInsurance createAutoInsurance(@RequestBody AutoInsurance autoInsurance) {
        return autoInsuranceService.saveAutoInsurance(autoInsurance);
    }

    @DeleteMapping("/delete/{autoInsuranceId}")
    public ResponseEntity<String> deleteAutoInsurance(@PathVariable Long autoInsuranceId) {
        boolean isDeleted = autoInsuranceService.deleteAutoInsurance(autoInsuranceId);
        return isDeleted ? ResponseEntity.ok("AutoInsurance deleted successfully") : ResponseEntity.status(404).body("AutoInsurance not found");
    }
    
}
