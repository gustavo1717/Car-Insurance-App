package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.AutoPlan;
import com.synex.domain.Claim;
import com.synex.domain.Policy;
import com.synex.domain.Claim;
import com.synex.repository.ClaimRepository;

@Service
public class ClaimService {
    @Autowired ClaimRepository claimRepository;

    public Claim createClaim(Claim claim) {
        return claimRepository.save(claim);
    }
    
    public Claim findClaimById(Long claimNumber) {
        // TODO Auto-generated method stub
        var optClaim = claimRepository.findById(claimNumber);
        return optClaim.isPresent()?optClaim.get():null;
    }
    
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }
    
    public Claim updateClaim(Long id, Claim updatedClaim) {
        Claim existingClaim = claimRepository.findById(id).orElse(null);
        if (existingClaim != null) {
            
            existingClaim.setStatus(updatedClaim.getStatus());

            return claimRepository.save(existingClaim);
        }
        return null; // Claim with the given ID doesn't exist
    }
    
    public List<Claim> getClaimByUser(String user) {
        return claimRepository.findByUsername(user);
    }
    
    public Claim reviewClaim(Long id, Claim updatedClaim) {
        Claim existingClaim = claimRepository.findById(id).orElse(null);
        if (existingClaim != null) {
            
            existingClaim.setStatus(updatedClaim.getStatus());
            existingClaim.setRepairPrice(updatedClaim.getRepairPrice());


            return claimRepository.save(existingClaim);
        }
        return null; // Policy with the given ID doesn't exist
    }
}