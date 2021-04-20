package com.hospital.hisspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Medicinemodel {
    @Id
    private String prescriptionid;
    private String prescriptionname;
    private String medicalid;
    private Integer amount;
    private String frequency;
    private String how;
    private String range;
}
