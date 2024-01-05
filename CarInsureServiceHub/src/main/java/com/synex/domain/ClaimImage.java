package com.synex.domain;

import jakarta.persistence.*;

@Embeddable
public class ClaimImage {

    

    @Lob
    @Column(name = "data")
    private String data;

    
    // Constructors

    public ClaimImage() {
    	super();
    }

    public ClaimImage( String data) {
        this.data = data;
        
    }

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
    
    

	
}