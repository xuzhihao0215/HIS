package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Patient;
import com.hospital.hisspring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/patient")
public class PatientHandler {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/findAll")
    public List<Patient> findAll(){
        return patientRepository.findAll();
    }
    @GetMapping("/autoGet/{identifyid}")
    public String autoGet(@PathVariable("identifyid") String identifyid){
        List<Patient> patients = findAll();
        int count = 0;
        String str = "";
        for (Patient patient : patients){
            if (patient.getIdentifyid().equals(identifyid)){
                str = "fail";
                break;
            }
        }
        if (!str.equals("fail")){
            do {
                Random ran = new Random();
                int num = ran.nextInt(999999);
                str = String.format("%06d", num);
                if(!patients.isEmpty()) {
                    for(Patient p : patients) {
                        if(str.equals(p.getMedicalrecordno())) {
                            count = 1;
                            break;
                        }
                    }
                }else {
                    return str;
                }
            }while(count == 1);
        }
        return str;
    }
    @GetMapping("/findBLH/{identifyid}")
    public String findBLH(@PathVariable("identifyid") String identifyid){
        List<Patient> patients = findAll();
        for (Patient patient : patients){
            if (patient.getIdentifyid().equals(identifyid)){
                return patient.getMedicalrecordno();
            }
        }
        return null;
    }
    @GetMapping("/getInformation/{medicalRecordNo}")
    public Patient getInformation(@PathVariable("medicalRecordNo") String medicalRecordNo){
        List<Patient> patients = findAll();
        for (Patient patient : patients){
            if (patient.getMedicalrecordno().equals(medicalRecordNo)){
                return patient;
            }
        }
        return null;
    }
    @PostMapping("/save")
    public String save(@RequestBody Patient patient){
        Patient result = patientRepository.save(patient);
        if (result != null){
            return "savesuccess";
        }else {
            return "savefail";
        }
    }
    @GetMapping("/findById/{medicalrecordno}")
    public Patient findById(@PathVariable("medicalrecordno") String medicalrecordno){
        return patientRepository.findById(medicalrecordno).get();
    }
}
