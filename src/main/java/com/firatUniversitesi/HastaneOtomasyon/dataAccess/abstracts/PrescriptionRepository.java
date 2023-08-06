package com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Patient;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Prescription;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

    List<Prescription> findByPatient(Patient patient);
}
