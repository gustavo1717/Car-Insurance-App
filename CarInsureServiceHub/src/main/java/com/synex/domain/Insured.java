package com.synex.domain;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "insured")
public class Insured {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String age;

    private String phone;
    
    private Integer drivingRecord;
    
    public String status;
    
    
    //private String status;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToOne(cascade = CascadeType.MERGE)
    private Address address;
    
    @OneToOne(cascade = CascadeType.MERGE)
    private Document document;
    
    /*@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "plans_id")
    private AutoPlan plans;*/
    
    /*@OneToMany( cascade = CascadeType.MERGE)
    private List<AutoPlan> plans;*/

    /*@OneToMany(cascade = CascadeType.MERGE)
    private AutoPlan plans;*/
   

    public Insured() {
        super();
        //this.vehicles = new ArrayList<>();
    }

    public Insured(String name, String email, String age, String phone, Integer drivingRecord, Address address, Document document,Vehicle vehicle,  String status) {
        super();
        this.name = name;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.drivingRecord = drivingRecord;
        this.address = address;
        this.document = document;
        //this.plans = plans;
        this.vehicle = vehicle;
        this.status = status;
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getage() {
        return age;
    }

    public void setage(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Integer getDrivingRecord() {
        return drivingRecord;
    }

    public void setDrivingRecord(Integer drivingRecord) {
        this.drivingRecord = drivingRecord;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public Document getDocument() {
    	return document;
    }
    
    public void setDocument(Document document) {
    	this.document = document;
    }
    
	

	/*public AutoPlan getPlans() {
		return plans;
	}

	public void setPlans(AutoPlan plans) {
		this.plans = plans;
	}*/

	/*public List<AutoPlan> getPlans() {
		return plans;
	}

	public void setPlans(List<AutoPlan> plans) {
		this.plans = plans;
	}*/

	public Vehicle getVehicle() {
    	return vehicle;
    }
    
    public void setVehicle(Vehicle vehicle) {
    	this.vehicle = vehicle;
    }
    
    public String getStatus() {
    	return status;
    }
    
    public void setStatus(String status) {
    	this.status = status;
    }
    
   
}