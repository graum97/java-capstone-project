package com.hackbright.capstoneApp.dtos;

import com.hackbright.capstoneApp.entities.ReadList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadListDto implements Serializable {
    private Long id;
    private UserDto userDto;
    private BookDto bookDto;
    private Date date;

    public ReadListDto(ReadList readList) {
        if (readList.getId() != null) {
            this.id = readList.getId();
        }
        if (readList.getDate() != null) {
            this.date = readList.getDate();
        }
    }
}
