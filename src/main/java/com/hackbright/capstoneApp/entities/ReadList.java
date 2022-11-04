package com.hackbright.capstoneApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hackbright.capstoneApp.dtos.ReadListDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "readList", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Book> bookSet = new HashSet<>();

    @Column
    private Date date;

    public ReadList(ReadListDto readListDto) {
        if (readListDto.getDate() != null) {
            this.date = readListDto.getDate();
        }
    }
}
