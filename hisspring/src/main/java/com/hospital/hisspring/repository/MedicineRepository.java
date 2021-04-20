package com.hospital.hisspring.repository;

import com.hospital.hisspring.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, String> {
}
