package com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
