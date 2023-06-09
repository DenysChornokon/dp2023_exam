package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Tank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
    private int year;
    private double weight;

    public Tank(String name, String country, int year, double weight) {
        this.name = name;
        this.country = country;
        this.year = year;
        this.weight = weight;
    }
}
