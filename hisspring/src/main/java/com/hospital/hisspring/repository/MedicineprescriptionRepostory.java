package com.hospital.hisspring.repository;

import com.hospital.hisspring.entity.Medicineprescription;
import com.hospital.hisspring.entity.MedicineprescriptionPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineprescriptionRepostory extends JpaRepository<Medicineprescription, MedicineprescriptionPrimaryKey> {
}
