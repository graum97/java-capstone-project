package com.hackbright.capstoneApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hackbright.capstoneApp.dtos.ReadListDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Read_List")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonBackReference
    private User user;

    @ManyToOne
    @JsonBackReference
    private Book book;

    @Column
    private Date date;

    public ReadList(ReadListDto readListDto) {
        if (readListDto.getDate() != null) {
            this.date = readListDto.getDate();
        }
    }
}
