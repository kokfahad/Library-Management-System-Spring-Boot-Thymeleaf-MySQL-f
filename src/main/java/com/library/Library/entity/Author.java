package com.library.Library.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;
    @Column(name = "description",nullable = false,length = 250)
    private String description;

    @ManyToMany(mappedBy = "authors" , cascade = CascadeType.ALL)
    Set<Book>books = new HashSet<Book>();

//    extra constructor

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
