package com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Polyclinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolyclinicRepository extends JpaRepository<Polyclinic, Integer> {
}
