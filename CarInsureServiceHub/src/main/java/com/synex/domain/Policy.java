package com.synex.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "policy")
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@OneToOne
	private Insured insured;
	
	@OneToOne(cascade = CascadeType.MERGE)
	Vehicle Vehicle;
	
	@OneToMany( cascade = CascadeType.MERGE)
	//@JoinColumn(name = "Policy_id")
    private List<AutoPlan> plans;
	
	private String status;
	
	private LocalDate startDate;
    private LocalDate endDate;
    
    
    private String username;
	
    public Policy(Long id, Insured insured, com.synex.domain.Vehicle vehicle, List<AutoPlan> plans, LocalDate startDate,
			LocalDate endDate, String status, String user) {
		super();
		this.id = id;
		this.insured = insured;
		Vehicle = vehicle;
		this.plans = plans;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.username = user;
	}
    
    
	public Policy() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	public Vehicle getVehicle() {
		return Vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		Vehicle = vehicle;
	}

	public List<AutoPlan> getPlans() {
		return plans;
	}

	public void setPlans(List<AutoPlan> plans) {
		this.plans = plans;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getUser() {
		return username;
	}


	public void setUser(String user) {
		this.username = user;
	}
	
	
	
	
 
}
