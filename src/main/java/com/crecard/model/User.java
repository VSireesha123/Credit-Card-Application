package com.crecard.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private String userId;
    private String password;

    @OneToOne(mappedBy = "user")
    private Customer customer;
}
