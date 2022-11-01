package com.hackbright.capstoneApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hackbright.capstoneApp.dtos.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @ManyToOne
    @JsonBackReference
    private BookGenre bookGenre;

    @Column
    private String ownership;

    @Column
    private Boolean read;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<BookGenre> bookGenreSet = new HashSet<>();

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<ReadList> readListSet = new HashSet<>();

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<ToReadList> toReadListSet = new HashSet<>();

    public Book(BookDto bookDto) {
        if (bookDto.getTitle() != null) {
            this.title = bookDto.getTitle();
        }
        if (bookDto.getAuthor() != null) {
            this.author = bookDto.getAuthor();
        }
        if (bookDto.getOwnership() != null) {
            this.ownership = bookDto.getOwnership();
        }
        if (bookDto.getRead() != null) {
            this.read = bookDto.getRead();
        }
    }
}
