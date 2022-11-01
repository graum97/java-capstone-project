package com.hackbright.capstoneApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.hackbright.capstoneApp.dtos.BookGenreDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Book_Genre")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Book book;

    @ManyToOne
    @JsonBackReference
    private Genre genre;

    @OneToMany(mappedBy = "bookGenre", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Book> bookSet = new HashSet<>();

//    public BookGenre (BookGenreDto bookGenreDto) {
//
//    }
}
