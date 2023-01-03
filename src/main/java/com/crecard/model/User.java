package com.crecard.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "userss")
public class User {

    @Id
    private String userId;
    private String password;

    @OneToOne(mappedBy = "user")
    private Customer customer;
    
    boolean isActive;
    @OneToOne(cascade=CascadeType.ALL)
    private Admin admin;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
    
}
