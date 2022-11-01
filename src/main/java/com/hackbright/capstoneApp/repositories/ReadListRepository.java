package com.hackbright.capstoneApp.repositories;

import com.hackbright.capstoneApp.entities.ReadList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadListRepository extends JpaRepository<ReadList, Long> {
}
