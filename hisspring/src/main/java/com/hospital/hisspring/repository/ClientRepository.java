package com.hospital.hisspring.repository;

import com.hospital.hisspring.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
