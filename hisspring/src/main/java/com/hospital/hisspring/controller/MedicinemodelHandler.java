package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Medicinemodel;
import com.hospital.hisspring.repository.MedicinemodelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicinemodel")
public class MedicinemodelHandler {
    @Autowired
    private MedicinemodelRepository medicinemodelRepository;

    @GetMapping("/findAll")
    public List<Medicinemodel> findAll(){
        return medicinemodelRepository.findAll();
    }
    @GetMapping("/findById/{preId}")
    public Medicinemodel findById(@PathVariable("preId") String preId){
        return medicinemodelRepository.findById(preId).get();
    }
}
