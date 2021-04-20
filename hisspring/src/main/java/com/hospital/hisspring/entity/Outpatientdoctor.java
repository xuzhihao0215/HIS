package com.hospital.hisspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Outpatientdoctor {
    @Id
    private String opdoctorid;
    private String username;
    private String rlid;
    private String professioninformation;
}
