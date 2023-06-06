package com.firatUniversitesi.HastaneOtomasyon.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "polyclinics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Polyclinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "polyclinic")
    private List<Doctor> doctors;
}
