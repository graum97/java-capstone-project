package com.hackbright.capstoneApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToReadListDto implements Serializable {
    private UserDto userDto;
    private BookDto bookDto;
}
