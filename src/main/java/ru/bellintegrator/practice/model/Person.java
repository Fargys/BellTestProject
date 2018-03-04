package ru.bellintegrator.practice.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Person")
public class Person {

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
     * Name
     */
    @Basic(optional = false)
    @Column(name = "first_name")
    private String name;

    /**
     * Age
     * because the field is a primitive type, it may not be nullable
     */
    @Basic(optional = false)
    @Column(name = "age")
    private int age;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "Person_House",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id")
    )

    private Set<House> houses;

    /**
     * Constructor for hibernate
     */
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<House> getHouses() {
        if (houses == null) {
            houses = new HashSet<>();
        }
        return houses;
    }

    public void addHouse(House house) {
        getHouses().add(house);
        house.getPersons().add(this);
    }

    public void removeHouse(House house) {
        getHouses().remove(house);
        house.getPersons().remove(this);
    }

}
