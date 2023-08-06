package com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Appointment;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Doctor;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>, JpaSpecificationExecutor<Appointment> {

    List<Appointment> findByPatient(Patient patient);

    List<Appointment> findByDoctor(Doctor doctor);
}
