package com.hospital.hisspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Department {
    @Id
    private String depid;
    private String depname;
    private String depclassification;
    private String depcategory;
    private String haid;
}
