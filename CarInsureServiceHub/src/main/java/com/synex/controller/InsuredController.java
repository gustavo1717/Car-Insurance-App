package com.synex.controller;

import com.synex.domain.Insured;
import com.synex.service.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8282")
@RestController
@RequestMapping("/insureds")
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @GetMapping("/{insuredId}")
    public Insured getInsuredById(@PathVariable Long insuredId) {
        return insuredService.getInsuredById(insuredId);
    }

    @GetMapping
    public List<Insured> getAllInsureds() {
        return insuredService.getAllInsureds();
    }

    @PostMapping("/saveInsured")
    public Insured createInsured(@RequestBody Insured insured) {
        return insuredService.saveInsured(insured);
    }

    @DeleteMapping("/deleteInsured/{id}")
    public void deleteInsured(@PathVariable Long id) {
        insuredService.deleteInsured(id);
    }
}
