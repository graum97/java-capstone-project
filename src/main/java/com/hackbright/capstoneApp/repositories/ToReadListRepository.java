package com.hackbright.capstoneApp.repositories;

import com.hackbright.capstoneApp.entities.ToReadList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToReadListRepository extends JpaRepository<ToReadList, Long> {
}
