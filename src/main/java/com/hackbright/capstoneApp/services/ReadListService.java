package com.hackbright.capstoneApp.services;

import com.hackbright.capstoneApp.dtos.ReadListDto;

import java.util.List;
import java.util.Optional;

public interface ReadListService {
    List<ReadListDto> getAllReadByUserId(Long userId);

    Optional<ReadListDto> getReadListById(Long readListId);
}
