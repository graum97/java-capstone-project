package com.hackbright.capstoneApp.controllers;

import com.hackbright.capstoneApp.dtos.BookDto;
import com.hackbright.capstoneApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/lists")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/user/{readListId}")
    public void addBookRead(@RequestBody BookDto bookDto, @PathVariable Long readListId) {
        bookService.addBookRead(bookDto, readListId);
    }

    @PostMapping("/user/toReadListId")
    public void addBookToRead(@RequestBody BookDto bookDto, @PathVariable Long toReadListId) {
        bookService.addBookToRead(bookDto, toReadListId);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBookById(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
    }

    @PutMapping("/{bookId}")
    public void updateBookById(@RequestBody BookDto bookDto) {
        bookService.updateBookById(bookDto);
    }
}
