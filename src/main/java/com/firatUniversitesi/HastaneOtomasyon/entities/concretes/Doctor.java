package com.firatUniversitesi.HastaneOtomasyon.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surName")
    private String surName;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "polyclinic_id")
    private Polyclinic polyclinic;




}
