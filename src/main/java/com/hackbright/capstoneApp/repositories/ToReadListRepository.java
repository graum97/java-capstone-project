package com.hackbright.capstoneApp.repositories;

import com.hackbright.capstoneApp.entities.ToReadList;
import com.hackbright.capstoneApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToReadListRepository extends JpaRepository<ToReadList, Long> {
    List<ToReadList> findAllByUserEquals(User user);
}
