package com.hospital.hisspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@IdClass(FinaldiagosticPrimaryKey.class)
public class Finaldiagostic {

    private String result;
    private String zhusu;
    private String xianbingshi;
    private String jiwangbingshi;
    private String guominshi;
    private String finaldiagostics;
    private String opdoctorid;
    @Id
    private String medicalrecordno;
    @Id
    private String registerid;
    @Id
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Finaldiagostic that = (Finaldiagostic) o;
        return Objects.equals(result, that.result) &&
                Objects.equals(zhusu, that.zhusu) &&
                Objects.equals(xianbingshi, that.xianbingshi) &&
                Objects.equals(jiwangbingshi, that.jiwangbingshi) &&
                Objects.equals(guominshi, that.guominshi) &&
                Objects.equals(finaldiagostics, that.finaldiagostics) &&
                Objects.equals(opdoctorid, that.opdoctorid) &&
                Objects.equals(medicalrecordno, that.medicalrecordno) &&
                Objects.equals(registerid, that.registerid) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, zhusu, xianbingshi, jiwangbingshi, guominshi, finaldiagostics, opdoctorid, medicalrecordno, registerid, date);
    }
}
