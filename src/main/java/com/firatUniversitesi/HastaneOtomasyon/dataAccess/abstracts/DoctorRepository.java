package com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Doctor;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Polyclinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findByPolyclinic(Polyclinic polyclinic);

    Optional<Doctor> findByUserName(String userName);
}
