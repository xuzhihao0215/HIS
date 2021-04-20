package com.hospital.hisspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Registrationlevel {
    @Id
    private String rlid;
    private String rspecification;
    private Integer limitbalance;
    private String sequencenum;
    private double fee;
}
