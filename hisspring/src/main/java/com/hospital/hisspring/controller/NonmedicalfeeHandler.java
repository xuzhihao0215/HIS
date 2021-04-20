package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Client;
import com.hospital.hisspring.entity.Nonmedicalfee;
import com.hospital.hisspring.repository.ClientRepository;
import com.hospital.hisspring.repository.NonmedicalfeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nonmedicalfee")
public class NonmedicalfeeHandler {
    @Autowired
    private NonmedicalfeeRepository nonmedicalfeeRepository;

    @GetMapping("/findAll")
    public List<Nonmedicalfee> findAll(){
        return nonmedicalfeeRepository.findAll();
    }
}
