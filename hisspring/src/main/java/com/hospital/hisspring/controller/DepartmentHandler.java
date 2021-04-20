package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Department;
import com.hospital.hisspring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentHandler {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/findAll")
    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
    @GetMapping("/findDepid/{depName}")
    public String findDepid(@PathVariable("depName") String depName){
        List<Department> departments = findAll();
        for(Department department : departments){
            if (department.getDepname().equals(depName)){
                return department.getDepid();
            }
        }
        return null;
    }
}
