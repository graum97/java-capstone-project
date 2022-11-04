package com.hackbright.capstoneApp.controllers;

import com.hackbright.capstoneApp.dtos.ReadListDto;
import com.hackbright.capstoneApp.entities.ReadList;
import com.hackbright.capstoneApp.services.ReadListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/readList")
public class ReadListController {
    @Autowired
    private ReadListService readListService;

    @GetMapping("/user/read/{userId}")
    public List<ReadListDto> getReadByUser(@PathVariable Long userId) {
        return readListService.getAllReadByUserId(userId);
    }

    @GetMapping("/{readListId}")
    public Optional<ReadListDto> getReadListById(@PathVariable Long readListId) {
        return readListService.getReadListById(readListId);
    }
}
