package com.hospital.hisspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Patient {
    private String name;
    private String sex;
    private String identifyid;
    private Date birthdate;
    private String cellphone;
    @Id
    private String medicalrecordno;
    private String address;
}
