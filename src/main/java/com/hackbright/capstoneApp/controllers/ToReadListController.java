package com.hackbright.capstoneApp.controllers;

import com.hackbright.capstoneApp.dtos.ToReadListDto;
import com.hackbright.capstoneApp.services.ToReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/toReadList")
public class ToReadListController {
    @Autowired
    private ToReadService toReadService;

    @GetMapping("/user/toRead/{userId}")
    public List<ToReadListDto> getToReadByUser(@PathVariable Long userId) {
        return toReadService.getAllToReadByUserId(userId);
    }

    @GetMapping("/{toReadListId}")
    public Optional<ToReadListDto> getToReadById(@PathVariable Long toReadListId) {
        return toReadService.getToReadById(toReadListId);
    }
}
