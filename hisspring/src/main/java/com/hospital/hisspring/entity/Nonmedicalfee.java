package com.hospital.hisspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Nonmedicalfee {
    @Id
    private String nmid;
    private String nmname;
    private String specification;
    private double unitprice;
    private String depid;
    private String nmcode;
    private String nmtype;
    private Date createdate;
    private String haid;
    private String expid;
}
