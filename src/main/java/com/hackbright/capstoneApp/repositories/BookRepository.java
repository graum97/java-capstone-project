package com.hackbright.capstoneApp.repositories;

import com.hackbright.capstoneApp.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
