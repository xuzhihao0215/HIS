package com.hospital.hisspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@IdClass(MedicineprescriptionPrimaryKey.class)
public class Medicineprescription {
    @Id
    private String medicalrecordno;
    @Id
    private String registerid;
    private String medicineid;
    @Id
    private String prescriptionid;
    private String opdoctorid;
    @Id
    private Date createtime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicineprescription that = (Medicineprescription) o;
        return Objects.equals(medicalrecordno, that.medicalrecordno) &&
                Objects.equals(registerid, that.registerid) &&
                Objects.equals(medicineid, that.medicineid) &&
                Objects.equals(prescriptionid, that.prescriptionid) &&
                Objects.equals(opdoctorid, that.opdoctorid) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicalrecordno, registerid, medicineid, prescriptionid, opdoctorid, createtime);
    }
}
