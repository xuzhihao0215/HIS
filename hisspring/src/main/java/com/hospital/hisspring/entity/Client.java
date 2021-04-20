package com.hospital.hisspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Client {
    @Id
    private String username;
    private String name;
    private String psw;
    private String depid;
    private String clientcategory;
}
