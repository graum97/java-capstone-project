package com.hackbright.capstoneApp.dtos;

import com.hackbright.capstoneApp.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Serializable {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String ownership;
    private Boolean read;
    private ReadListDto readListDto;
    private ToReadListDto toReadListDto;
    public BookDto(Book book) {
        if (book.getId() != null) {
            this.id = book.getId();
        }
        if (book.getTitle() != null) {
            this.title = book.getTitle();
        }
        if (book.getAuthor() != null) {
            this.author = book.getAuthor();
        }
        if (book.getGenre() != null) {
            this.genre = book.getGenre();
        }
        if (book.getOwnership() != null) {
            this.ownership = book.getOwnership();
        }
        if (book.getRead() != null) {
            this.read = book.getRead();
        }
    }
}
