package com.synex.service;

import com.synex.domain.AutoPlan;
import com.synex.repository.AutoPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoPlanService {

    @Autowired
    private AutoPlanRepository autoPlanRepository;

    public Optional<AutoPlan> getAutoPlanById(Long id) {
        return autoPlanRepository.findById(id);
    }

    public List<AutoPlan> getAllAutoPlans() {
        return autoPlanRepository.findAll();
    }

    public AutoPlan saveAutoPlan(AutoPlan autoPlan) {
        return autoPlanRepository.save(autoPlan);
    }

    public boolean deleteAutoPlan(Long id) {
        Optional<AutoPlan> autoPlanOptional = autoPlanRepository.findById(id);
        if (autoPlanOptional.isPresent()) {
            autoPlanRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
