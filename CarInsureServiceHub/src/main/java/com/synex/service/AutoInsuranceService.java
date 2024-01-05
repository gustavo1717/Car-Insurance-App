package com.synex.service;

import com.synex.domain.AutoInsurance;
import com.synex.repository.AutoInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoInsuranceService {

    @Autowired
    private AutoInsuranceRepository autoInsuranceRepository;

    public Optional<AutoInsurance> getAutoInsuranceById(Long id) {
        return autoInsuranceRepository.findById(id);
    }

    public List<AutoInsurance> getAllAutoInsurance() {
        return autoInsuranceRepository.findAll();
    }

    public AutoInsurance saveAutoInsurance(AutoInsurance autoInsurance) {
        return autoInsuranceRepository.save(autoInsurance);
    }
    
    public boolean deleteAutoInsurance(Long id) {
        Optional<AutoInsurance> autoInsuranceOptional = autoInsuranceRepository.findById(id);
        if (autoInsuranceOptional.isPresent()) {
            autoInsuranceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
