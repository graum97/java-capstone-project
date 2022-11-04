package com.hackbright.capstoneApp.services;

import com.hackbright.capstoneApp.dtos.ToReadListDto;
import com.hackbright.capstoneApp.entities.Book;
import com.hackbright.capstoneApp.entities.ToReadList;
import com.hackbright.capstoneApp.entities.User;
import com.hackbright.capstoneApp.repositories.ToReadListRepository;
import com.hackbright.capstoneApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToReadServiceImpl implements ToReadService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ToReadListRepository toReadListRepository;

    @Override
    public List<ToReadListDto> getAllToReadByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<ToReadList> toReadListList = toReadListRepository.findAllByUserEquals(userOptional.get());
            return toReadListList.stream().map(toReadList -> new ToReadListDto(toReadList)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<ToReadListDto> getToReadById(Long toReadListId) {
        Optional<ToReadList> toReadListOptional = toReadListRepository.findById(toReadListId);
        if (toReadListOptional.isPresent()) {
            return Optional.of(new ToReadListDto(toReadListOptional.get()));
        }
        return Optional.empty();
    }

}
