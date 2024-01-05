package com.synex.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class AutoPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String description;
    private double basePrice;
    private String imageURL;
    
    @ManyToOne
    private Policy policy;
    
    /*@ManyToOne
    @JoinColumn(name = "insured_id") // Add a foreign key column in AutoPlan
    private Insured insured;*/
    
    /*@ManyToOne
    private Insured insured;*/
    
    //@OneToOne(cascade = CascadeType.ALL)
    //@OneToOne()
   // @JoinColumn(name = "autoInsurance_id")
    //private AutoInsurance autoInsurance;

    // constructors
    public AutoPlan() {
    }
    
    public AutoPlan(String name) {
        this.name = name;
    }


    public AutoPlan(String name, String type, String description, double basePrice, String imageURL, Policy policy) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.basePrice = basePrice;
        this.imageURL = imageURL;
        this.policy = policy;
        //this.insured = insured;
    }

    

	// getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    
    public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	/*public List<Insured> getInsured() {
		return insured;
	}

	public void setInsured(List<Insured> insured) {
		this.insured = insured;
	}*/
	

	/*public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}*/
	
	
    
    
  
}