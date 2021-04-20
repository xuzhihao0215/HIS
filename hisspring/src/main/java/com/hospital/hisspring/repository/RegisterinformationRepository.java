package com.hospital.hisspring.repository;

import com.hospital.hisspring.entity.Registerinformation;
import com.hospital.hisspring.entity.RegisterinformationPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterinformationRepository extends JpaRepository<Registerinformation, RegisterinformationPrimaryKey> {
}
