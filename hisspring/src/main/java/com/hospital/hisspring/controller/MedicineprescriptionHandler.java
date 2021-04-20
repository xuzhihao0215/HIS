package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Medicineprescription;
import com.hospital.hisspring.repository.MedicineprescriptionRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/medicineprescription")
public class MedicineprescriptionHandler {
    @Autowired
    private MedicineprescriptionRepostory medicineprescriptionRepostory;

    @GetMapping("/findAll")
    public List<Medicineprescription> findAll(){
        return medicineprescriptionRepostory.findAll();
    }
    @PostMapping("/save")
    public String save(@RequestBody Medicineprescription medicineprescription){
        medicineprescription.setCreatetime(new Date());
        medicineprescriptionRepostory.save(medicineprescription);
        return "savesuccess";
    }
}
