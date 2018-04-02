package ru.bellintegrator.denisov.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Citizenship")
@NamedQuery(name = "Citizenship.findAll", query = "SELECT p FROM Citizenship p") 
public class Citizenship implements Serializable  {
    
    @Id
    @Column(name = "country_code")
    private Long countryCode;
    
    @Version
    private Integer version = 0;
    
    @Column(name = "country_name")
    private String countryName;
    

    public Citizenship() {
    }

    public Long getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Long countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    
}