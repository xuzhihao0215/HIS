package com.hospital.hisspring.repository;

import com.hospital.hisspring.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
