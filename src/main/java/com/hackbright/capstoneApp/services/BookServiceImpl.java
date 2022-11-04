package com.hackbright.capstoneApp.services;

import com.hackbright.capstoneApp.dtos.BookDto;
import com.hackbright.capstoneApp.entities.Book;
import com.hackbright.capstoneApp.entities.ReadList;
import com.hackbright.capstoneApp.entities.ToReadList;
import com.hackbright.capstoneApp.repositories.BookRepository;
import com.hackbright.capstoneApp.repositories.ReadListRepository;
import com.hackbright.capstoneApp.repositories.ToReadListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private ReadListRepository readListRepository;

    @Autowired
    private ToReadListRepository toReadListRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional
    public void addBookRead(BookDto bookDto, Long readListId) {
        Optional<ReadList> readListOptional = readListRepository.findById(readListId);
        Book book = new Book(bookDto);
        readListOptional.ifPresent(book::setReadList);
        bookRepository.saveAndFlush(book);
    }

    @Override
    @Transactional
    public void addBookToRead(BookDto bookDto, Long toReadListId) {
        Optional<ToReadList> toReadListOptional = toReadListRepository.findById(toReadListId);
        Book book = new Book(bookDto);
        toReadListOptional.ifPresent(book::setToReadList);
        bookRepository.saveAndFlush(book);
    }

    @Override
    @Transactional
    public void deleteBookById(Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        bookOptional.ifPresent(book -> bookRepository.delete(book));
    }

    @Override
    @Transactional
    public void updateBookById(BookDto bookDto) {
        Optional<Book> bookOptional = bookRepository.findById(bookDto.getId());
        bookOptional.ifPresent(book -> {
            book.setRead(bookDto.getRead());
            bookRepository.saveAndFlush(book);
        });
    }
}
