package com.firatUniversitesi.HastaneOtomasyon.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "patients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surName")
    private String surName;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identityNumber")
    private String identityNumber;

    @OneToMany(mappedBy = "patient")
    private List<Finding> findings;

    @OneToMany(mappedBy = "patient")
    private List<Prescription> prescriptions;

    @OneToMany(mappedBy = "patient")
    private List<Report> reports;
}
