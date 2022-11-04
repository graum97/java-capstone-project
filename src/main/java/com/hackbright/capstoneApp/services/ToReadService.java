package com.hackbright.capstoneApp.services;

import com.hackbright.capstoneApp.dtos.ToReadListDto;

import java.util.List;
import java.util.Optional;

public interface ToReadService {
    List<ToReadListDto> getAllToReadByUserId(Long userId);

    Optional<ToReadListDto> getToReadById(Long toReadListId);
}
