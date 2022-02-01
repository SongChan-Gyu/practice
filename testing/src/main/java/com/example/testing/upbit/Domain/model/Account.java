package com.example.testing.upbit.Domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String currency;

    public double balance;

    public double locked;

    public double avg_buy_price;

    public boolean avg_buy_price_modified;

    public String unit_currency;

}
