package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.synex.domain.Insured;
import com.synex.repository.InsuredRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InsuredService {

    @Autowired
    private InsuredRepository insuredRepository;

    public Insured getInsuredById(Long insuredId) {
        Optional<Insured> optionalInsured = insuredRepository.findById(insuredId);
        return optionalInsured.orElse(null);
    }

    public List<Insured> getAllInsureds() {
        return insuredRepository.findAll();
    }

    public Insured saveInsured(Insured insured) {
        return insuredRepository.save(insured);
    }

    public void deleteInsured(Long id) {
        insuredRepository.deleteById(id);
    }
}
