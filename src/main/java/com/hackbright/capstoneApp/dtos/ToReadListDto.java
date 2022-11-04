package com.hackbright.capstoneApp.dtos;

import com.hackbright.capstoneApp.entities.ToReadList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToReadListDto implements Serializable {
    private Long id;
    private UserDto userDto;
    private BookDto bookDto;

    public ToReadListDto(ToReadList toReadList) {
        if (toReadList.getId() != null) {
            this.id = toReadList.getId();
        }
    }
}
