package com.hackbright.capstoneApp.dtos;

import com.hackbright.capstoneApp.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto implements Serializable {
    private Long id;
    private String name;

    public GenreDto(Genre genre) {
        if (genre.getId() != null) {
            this.id = genre.getId();
        }
        if (genre.getName() != null) {
            this.name = genre.getName();
        }
    }
}
