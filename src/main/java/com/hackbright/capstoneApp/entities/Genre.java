package com.hackbright.capstoneApp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hackbright.capstoneApp.dtos.GenreDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Genres")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<BookGenre> bookGenreSets = new HashSet<>();

    public Genre(GenreDto genreDto) {
        if (genreDto.getName() != null) {
            this.name = genreDto.getName();
        }
    }
}
