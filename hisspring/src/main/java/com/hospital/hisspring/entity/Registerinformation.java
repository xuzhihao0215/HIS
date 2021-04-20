package com.hospital.hisspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@IdClass(RegisterinformationPrimaryKey.class)
public class Registerinformation {
    @Id
    private String medicalrecordno;
    @Id
    private String registerid;
    private String name;
    private String sex;
    private Integer age;
    private Date birthdate;
    private String payway;
    private String identifyid;
    private String address;
    private String rlid;
    private String opdoctorid;
    private String depid;
    private String medicalrecordbook;
    private double fee;
    private String patientstate;
    @Id
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registerinformation that = (Registerinformation) o;
        return Double.compare(that.fee, fee) == 0 &&
                Objects.equals(medicalrecordno, that.medicalrecordno) &&
                Objects.equals(registerid, that.registerid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(age, that.age) &&
                Objects.equals(birthdate, that.birthdate) &&
                Objects.equals(payway, that.payway) &&
                Objects.equals(identifyid, that.identifyid) &&
                Objects.equals(address, that.address) &&
                Objects.equals(rlid, that.rlid) &&
                Objects.equals(opdoctorid, that.opdoctorid) &&
                Objects.equals(depid, that.depid) &&
                Objects.equals(medicalrecordbook, that.medicalrecordbook) &&
                Objects.equals(patientstate, that.patientstate) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicalrecordno, registerid, name, sex, age, birthdate, payway, identifyid, address, rlid, opdoctorid, depid, medicalrecordbook, fee, patientstate, date);
    }
}
