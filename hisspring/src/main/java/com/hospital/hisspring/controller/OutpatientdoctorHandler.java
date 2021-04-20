package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Outpatientdoctor;
import com.hospital.hisspring.repository.OutpatientdoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outpatientdoctor")
public class OutpatientdoctorHandler {
    @Autowired
    private OutpatientdoctorRepository outpatientdoctorRepository;

    @GetMapping("/findAll")
    public List<Outpatientdoctor> findAll(){
        return outpatientdoctorRepository.findAll();
    }

    @GetMapping("/getId/{username}")
    public String getId(@PathVariable("username") String username){
        List<Outpatientdoctor> outpatientdoctors = findAll();
        for (Outpatientdoctor outpatientdoctor : outpatientdoctors){
            if(outpatientdoctor.getUsername().equals(username)){
                return outpatientdoctor.getOpdoctorid();
            }
        }
        return null;
    }
}
