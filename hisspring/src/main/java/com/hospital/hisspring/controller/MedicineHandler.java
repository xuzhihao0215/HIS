package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Client;
import com.hospital.hisspring.entity.Medicine;
import com.hospital.hisspring.repository.ClientRepository;
import com.hospital.hisspring.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineHandler {
    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping("/findAll")
    public List<Medicine> findAll(){
        return medicineRepository.findAll();
    }
    @GetMapping("/getMedicine/{medicalid}")
    public List<Medicine> getMedicine(@PathVariable("medicalid") String medicalid){
        System.out.println(medicalid);
        String[] medicalID = medicalid.split("；");
        List<Medicine> medicineList = new ArrayList<>();
        System.out.println(Arrays.toString(medicalID));
        for (String id : medicalID){
            System.out.println(id);
            medicineList.add(medicineRepository.findById(id).get());
        }
        return medicineList;
    }
    @GetMapping("/getMoney/{medicalid}/{number}")
    public double getMedicine(@PathVariable("medicalid") String medicalid,@PathVariable("number") String number){
        int amount = Integer.parseInt(number);
        String[] medicalID = medicalid.split("；");
        double totalprice= 0;
        for (String id : medicalID){
            totalprice = totalprice + medicineRepository.findById(id).get().getUnitprice()*amount;
        }
        return totalprice;
    }

}
