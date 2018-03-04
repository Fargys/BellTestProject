package ru.bellintegrator.practice.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "House")
public class House {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    /**
     * Hibernate service field
     */
    @Version
    private Integer version;

    /**
     * Address
     */
    @Basic(optional = false)
    @Column(name = "address")
    private String address;

    @ManyToMany(mappedBy = "houses")
    private Set<Person> persons;

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Person> getPersons() {
        if (persons == null) {
            persons = new HashSet<>();
        }
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}