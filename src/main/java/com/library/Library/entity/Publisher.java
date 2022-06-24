package com.library.Library.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "publishers" , cascade = CascadeType.ALL)
    Set<Book> books = new HashSet<Book>();

//    extra constructors

    public Publisher(String name) {
        this.name = name;
    }
}
