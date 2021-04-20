package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Finaldiagostic;
import com.hospital.hisspring.repository.FinaldiagosticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/finaldiagostic")
public class FianldiagosticHandler {

    @Autowired
    private FinaldiagosticRepository finaldiagosticRepository;

    @GetMapping("/findAll")
    public List<Finaldiagostic> findAll(){
        return finaldiagosticRepository.findAll();
    }
    @PostMapping("/treat")
    public String treat(@RequestBody Finaldiagostic finaldiagostic){
        finaldiagostic.setDate(new Date());
        finaldiagosticRepository.save(finaldiagostic);
        return "success";
    }
    @GetMapping("/getFinal/{medicalrecordno}")
    public Finaldiagostic getFinal(@PathVariable("medicalrecordno") String medicalrecordno){
        List<Finaldiagostic> finaldiagostics = findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String newDate = sdf.format(new Date());
        for (Finaldiagostic finaldiagostic : finaldiagostics){
            if (newDate.equals(sdf.format(finaldiagostic.getDate())) && finaldiagostic.getMedicalrecordno().equals(medicalrecordno)){
                return finaldiagostic;
            }
        }
        return null;
    }

}
