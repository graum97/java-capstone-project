package com.hackbright.capstoneApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "To_Read_List")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToReadList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonBackReference
    private User user;

    @ManyToOne
    @JsonBackReference
    private Book book;
}
