package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Registerinformation;
import com.hospital.hisspring.repository.RegisterinformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/registerinformation")
public class RegisterinformationHandler {
    @Autowired
    private RegisterinformationRepository registerinformationRepository;

    @GetMapping("/findAll")
    public List<Registerinformation> findAll(){
        return registerinformationRepository.findAll();
    }

    @PostMapping("/registration")
    public String registration(@RequestBody Registerinformation registerinformation){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String newDate = sdf.format(new Date());
        int count = 0;
        String str;
        do {
            Random ran = new Random();
            int num = ran.nextInt(999999);
            str = newDate + String.format("%06d", num);
            List<Registerinformation> registerinformations = findAll();
            if(!registerinformations.isEmpty()) {
                for(Registerinformation r : registerinformations) {
                    if (r.getMedicalrecordbook().equals(registerinformation.getMedicalrecordno()) && r.getDate().equals(registerinformation.getDate())){
                        return "registerrepeat";
                    }
                    if(str.equals(r.getRegisterid())) {
                        count = 1;
                        break;
                    }
                }
            }else {
                registerinformation.setRegisterid(str);
                registerinformationRepository.save(registerinformation);
                return "registersuccess";
            }
        }while(count == 1);
        registerinformation.setRegisterid(str);
        registerinformationRepository.save(registerinformation);
        return "registersuccess";
    }

    @GetMapping("/getusednum/{RLID}")
    public int getusednum(@PathVariable("RLID") String RLID){
        List<Registerinformation> registerinformations = findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sdf.format(new Date());
        int count = 0;
        for (Registerinformation registerinformation : registerinformations){
            if (registerinformation.getRlid().equals(RLID) && sdf.format(registerinformation.getDate()).equals(newDate)){
                count++;
            }
        }
        return count;
    }
    
    @GetMapping("/findPart/{opdoctorid}")
    public List<Registerinformation> findPart(@PathVariable("opdoctorid") String opdoctorid){
        List<Registerinformation> registerinformations = findAll();
        List<Registerinformation> registerinformationList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sdf.format(new Date());
        for (Registerinformation registerinformation : registerinformations){
            if (registerinformation.getOpdoctorid().equals(opdoctorid) && sdf.format(registerinformation.getDate()).equals(newDate) && registerinformation.getPatientstate().equals("ready")){
                registerinformationList.add(registerinformation);
            }
        }
        return registerinformationList;
    }
    @GetMapping("/findParted/{opdoctorid}")
    public List<Registerinformation> findParted(@PathVariable("opdoctorid") String opdoctorid){
        List<Registerinformation> registerinformations = findAll();
        List<Registerinformation> registerinformationList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sdf.format(new Date());
        for (Registerinformation registerinformation : registerinformations){
            if (registerinformation.getOpdoctorid().equals(opdoctorid) && sdf.format(registerinformation.getDate()).equals(newDate) && registerinformation.getPatientstate().equals("done")){
                registerinformationList.add(registerinformation);
            }
        }
        return registerinformationList;
    }
    @GetMapping("/findOfficePart/{depid}")
    public List<Registerinformation> findOfficePart(@PathVariable("depid") String depid){
        List<Registerinformation> registerinformations = findAll();
        List<Registerinformation> registerinformationList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sdf.format(new Date());
        if(registerinformations != null){
            for (Registerinformation registerinformation : registerinformations){
                if (registerinformation.getDepid().equals(depid) && sdf.format(registerinformation.getDate()).equals(newDate) && registerinformation.getPatientstate().equals("ready")){
                    registerinformationList.add(registerinformation);
                }
            }
        }
        return registerinformationList;
    }
    @GetMapping("/findOfficeParted/{depid}")
    public List<Registerinformation> findOfficeParted(@PathVariable("depid") String depid){
        List<Registerinformation> registerinformations = findAll();
        List<Registerinformation> registerinformationList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sdf.format(new Date());
        for (Registerinformation registerinformation : registerinformations){
            if (registerinformation.getDepid().equals(depid) && sdf.format(registerinformation.getDate()).equals(newDate) && registerinformation.getPatientstate().equals("done")){
                registerinformationList.add(registerinformation);
            }
        }
        return registerinformationList;
    }
    @PostMapping("/findPatient/{medicalrecordno}")
    public String findPatient(@PathVariable("medicalrecordno") String medicalrecordno){
        List<Registerinformation> registerinformations = findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sdf.format(new Date());
        for (Registerinformation registerinformation : registerinformations){
            if (registerinformation.getMedicalrecordno().equals(medicalrecordno) && sdf.format(registerinformation.getDate()).equals(newDate) && registerinformation.getPatientstate().equals("ready")){
                registerinformation.setPatientstate("done");
                registerinformationRepository.save(registerinformation);
                return "treatsuccess";
            }
        }
        return null;
    }
    @GetMapping("/findRegisterid/{medicalrecordno}")
    public String findRegisterid(@PathVariable("medicalrecordno") String medicalrecordno){
        List<Registerinformation> registerinformations = findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sdf.format(new Date());
        for (Registerinformation registerinformation : registerinformations){
            if (registerinformation.getMedicalrecordno().equals(medicalrecordno) && sdf.format(registerinformation.getDate()).equals(newDate) && registerinformation.getPatientstate().equals("ready")){
                return registerinformation.getRegisterid();
            }
        }
        return null;
    }
}
