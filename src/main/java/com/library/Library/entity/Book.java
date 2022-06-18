package com.library.Library.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "isbn", length = 50, nullable = false, unique = true)
    private String isbn;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "description",nullable = false,length = 250)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_author",
    joinColumns = {@JoinColumn(name = "book_id")}, inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author>authors = new HashSet<Author>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_categories",
            joinColumns = {@JoinColumn(name = "book_id")}, inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category>categories = new HashSet<Category>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_publishers",
            joinColumns = {@JoinColumn(name = "book_id")}, inverseJoinColumns = {@JoinColumn(name = "publisher_id")})
    private Set<Publisher>publishers = new HashSet<Publisher>();
}
