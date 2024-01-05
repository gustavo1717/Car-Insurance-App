package com.synex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.synex.domain.Claim;
import com.synex.domain.Policy;
import com.synex.repository.ClaimRepository;
import com.synex.service.ClaimService;

@RestController
public class ClaimController {
	
	@Autowired ClaimService claimService;
	@Autowired ClaimRepository claimRepository;

	
	@PostMapping("/createClaim")
    public Claim createClaim(@RequestBody JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Claim claim = mapper.convertValue(node, Claim.class);
        System.out.println(node);
        System.out.println();
        System.out.println(claim.getImages().get(0).getData());
        return claimService.createClaim(claim);
    }
	
	 @GetMapping("/claims")
	    public List<Claim> getAllClaims() {
	        return claimService.getAllClaims();
	    }
	 
	 @PutMapping("/claims/{id}")
	    public Claim updateClaim(@PathVariable Long id, @RequestBody Claim claim) {
	        claim.setId(id);
	        return claimService.updateClaim(id, claim);
	    }
	 
	 @GetMapping("/claims/byUser/{username}")
	    public List<Claim> getClaimByUser(@PathVariable String username) {
	        return claimService.getClaimByUser(username);
	    }
	 
	 /*@PutMapping("/claims/updateRepairPrice/{id}")
	 public ResponseEntity<Claim> updateRepairPrice(@PathVariable Long id, @RequestBody Map<String, Object> request) {
	     Claim existingClaim = claimService.findClaimById(id);
	     if (existingClaim != null) {
	         Object repairPriceObject = request.get("repairPrice");

	         if (repairPriceObject instanceof Integer) {
	             // Convert the Integer value to Double
	             existingClaim.setRepairPrice(((Integer) repairPriceObject).doubleValue());
	         } else if (repairPriceObject instanceof Double) {
	             // If it's already a Double, use it as is
	             existingClaim.setRepairPrice((Double) repairPriceObject);
	         } else {
	             // Handle other cases as needed
	             // You may want to return an error response if the input is not valid.
	             //return ResponseEntity.badRequest().body("Invalid repairPrice format");
	         }
	         
	         // Continue with your update logic
	         // ...

	         return ResponseEntity.ok(existingClaim); // Successfully updated
	     } else {
	         return ResponseEntity.notFound().build(); // Claim not found
	     }
	 }*/
	 @PutMapping("/reviewClaim/{id}")
	    public ResponseEntity<Claim> reviewClaim(@PathVariable Long id, @RequestBody Claim updatedClaim) {
		 Claim existingClaim = claimService.findClaimById(id);
	        if (existingClaim != null) {
	            existingClaim.setStatus(updatedClaim.getStatus());
	            existingClaim.setRepairPrice(updatedClaim.getRepairPrice());

	            Claim updatedClaimResult = claimRepository.save(existingClaim);
	            return ResponseEntity.ok(updatedClaimResult); // Successfully updated
	        } else {
	            return ResponseEntity.notFound().build(); // Claim not found
	        }
	    }

}
