package com.kaideas.springframework.ij_spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kt on 05/16/2020
 */
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;

    @OneToMany(
            mappedBy = "post",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Publisher(String name, String city, String state, String zip) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.zip = zip;
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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
