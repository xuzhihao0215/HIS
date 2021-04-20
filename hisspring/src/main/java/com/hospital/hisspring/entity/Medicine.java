package com.hospital.hisspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Medicine {
    @Id
    private String medicineid;
    private String medicinename;
    private String medicinecode;
    private String medicinespecification;
    private String dosage;
    private String packingcompany;
    private double unitprice;
    private String medicineclassify;
    private String maid;
}
