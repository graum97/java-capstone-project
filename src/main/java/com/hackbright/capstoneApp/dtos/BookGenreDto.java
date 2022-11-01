package com.hackbright.capstoneApp.dtos;

import com.hackbright.capstoneApp.entities.BookGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookGenreDto implements Serializable {
    private Long id;
    private BookDto bookDto;
    private GenreDto genreDto;

    public BookGenreDto(BookGenre bookGenre) {
        if (bookGenre.getId() != null) {
            this.id = bookGenre.getId();
        }
    }
}
