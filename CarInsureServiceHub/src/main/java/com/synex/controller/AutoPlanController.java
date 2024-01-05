package com.synex.controller;

import com.synex.domain.AutoPlan;

import com.synex.service.AutoPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8282")
@RestController
@RequestMapping("/autoPlan")
public class AutoPlanController {

    @Autowired
    private AutoPlanService autoPlanService;

    @GetMapping("/{autoPlanId}")
    public ResponseEntity<AutoPlan> getAutoPlanById(@PathVariable Long autoPlanId) {
        Optional<AutoPlan> autoPlan = autoPlanService.getAutoPlanById(autoPlanId);
        return autoPlan.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<AutoPlan> getAllAutoPlans() {
        return autoPlanService.getAllAutoPlans();
    }

    @PostMapping("/saveAutoPlan")
    public AutoPlan createAutoPlan(@RequestBody AutoPlan autoPlan) {
        return autoPlanService.saveAutoPlan(autoPlan);
    }

    @DeleteMapping("/delete/{autoPlanId}")
    public ResponseEntity<String> deleteAutoPlan(@PathVariable Long autoPlanId) {
        boolean isDeleted = autoPlanService.deleteAutoPlan(autoPlanId);
        return isDeleted ? ResponseEntity.ok("AutoPlan deleted successfully") : ResponseEntity.status(404).body("AutoPlan not found");
    }
}
