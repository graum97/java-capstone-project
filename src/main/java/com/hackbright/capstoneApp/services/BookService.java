package com.hackbright.capstoneApp.services;

import com.hackbright.capstoneApp.dtos.BookDto;

import javax.transaction.Transactional;

public interface BookService {
    @Transactional
    void addBookRead(BookDto bookDto, Long readListId);

    @Transactional
    void addBookToRead(BookDto bookDto, Long toReadListId);

    @Transactional
    void deleteBookById(Long bookId);

    @Transactional
    void updateBookById(BookDto bookDto);
}
