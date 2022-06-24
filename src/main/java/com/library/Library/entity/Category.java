package com.library.Library.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, length = 50,nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories" , cascade = CascadeType.ALL)
    Set<Book> books = new HashSet<Book>();

    //extra constructors


    public Category(String name) {
        this.name = name;
    }
}
