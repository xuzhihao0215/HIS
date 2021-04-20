package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Client;
import com.hospital.hisspring.entity.Registrationlevel;
import com.hospital.hisspring.repository.ClientRepository;
import com.hospital.hisspring.repository.RegistrationlevelRepostion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registrationlevel")
public class RegistrationlevelHandler {
    @Autowired
    private RegistrationlevelRepostion registrationlevelRepostion;

    @GetMapping("/findAll")
    public List<Registrationlevel> findAll(){
        return registrationlevelRepostion.findAll();
    }
    @GetMapping("/getlimit/{RLID}")
    public int getlimit(@PathVariable("RLID") String RLID){
        List<Registrationlevel> registrationlevels = findAll();
        for (Registrationlevel registrationlevel : registrationlevels){
            if(registrationlevel.getRlid().equals(RLID)){
                return registrationlevel.getLimitbalance();
            }
        }
        return 0;
    }
    @GetMapping("/getmoney/{RLID}")
    public Double getmoney(@PathVariable("RLID") String RLID){
        List<Registrationlevel> registrationlevels = findAll();
        for (Registrationlevel registrationlevel : registrationlevels){
            if(registrationlevel.getRlid().equals(RLID)){
                return registrationlevel.getFee();
            }
        }
        return 0.0;
    }
}
