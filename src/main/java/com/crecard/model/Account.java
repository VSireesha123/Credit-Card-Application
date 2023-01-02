package com.crecard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "account")
@EqualsAndHashCode
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String accountName;
    private double balance;
    private String accountType;

    @OneToOne(mappedBy = "account")
    @JoinColumn(name = "accountId", referencedColumnName = "accountId", insertable = false, updatable = false)
    @JsonIgnore
    private Customer customer;

}
