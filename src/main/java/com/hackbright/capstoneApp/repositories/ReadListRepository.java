package com.hackbright.capstoneApp.repositories;

import com.hackbright.capstoneApp.entities.ReadList;
import com.hackbright.capstoneApp.entities.ToReadList;
import com.hackbright.capstoneApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadListRepository extends JpaRepository<ReadList, Long> {
    List<ReadList> findAllByUserEquals(User user);

}
