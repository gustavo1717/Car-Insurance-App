package com.synex.service;

import com.synex.domain.Policy;
import com.synex.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    @Autowired
    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public Policy createPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id).orElse(null);
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Policy updatePolicy(Long id, Policy updatedPolicy) {
        Policy existingPolicy = policyRepository.findById(id).orElse(null);
        if (existingPolicy != null) {
            
            existingPolicy.setStatus(updatedPolicy.getStatus());

            return policyRepository.save(existingPolicy);
        }
        return null; // Policy with the given ID doesn't exist
    }

    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }
    
    public List<Policy> getPolicyByUser(String user) {
        return policyRepository.findByUsername(user);
    }
}
