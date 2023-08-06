package com.firatUniversitesi.HastaneOtomasyon.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "findings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Finding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "content")
    private String content;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
