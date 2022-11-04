package com.hackbright.capstoneApp.services;

import com.hackbright.capstoneApp.dtos.ReadListDto;
import com.hackbright.capstoneApp.entities.ReadList;
import com.hackbright.capstoneApp.entities.User;
import com.hackbright.capstoneApp.repositories.ReadListRepository;
import com.hackbright.capstoneApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReadListServiceImpl implements ReadListService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReadListRepository readListRepository;

    @Override
    public List<ReadListDto> getAllReadByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<ReadList> readListList = readListRepository.findAllByUserEquals(userOptional.get());
            return readListList.stream().map(readList -> new ReadListDto(readList)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<ReadListDto> getReadListById(Long readListId) {
        Optional<ReadList> readListOptional = readListRepository.findById(readListId);
        if (readListOptional.isPresent()) {
            return Optional.of(new ReadListDto(readListOptional.get()));
        }
        return Optional.empty();
    }
}
