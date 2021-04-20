package com.hospital.hisspring.repository;

import com.hospital.hisspring.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {
}
