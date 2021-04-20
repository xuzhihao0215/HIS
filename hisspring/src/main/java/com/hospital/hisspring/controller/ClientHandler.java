package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Client;
import com.hospital.hisspring.entity.Department;
import com.hospital.hisspring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientHandler {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/findAll")
    public List<Client> findAll(){
        return clientRepository.findAll();
    }
    @GetMapping("/findById/{username}")
    public Client findById(@PathVariable("username") String username){
        return clientRepository.findById(username).orElse(null);
    }
    @GetMapping("/login/{username}/{password}")
    public String login(@PathVariable("username") String username, @PathVariable("password") String password) {
        Client client = findById(username);
        if (client != null) {
            if (client.getPsw().equals(password)) {
                if (client.getClientcategory().equals("0")) {
                    return "registersuccess";
                } else if (client.getClientcategory().equals("1")) {
                    return "outpatientsuccess";
                }
            } else {
                return "fail";
            }
        } else {
            return "fail";
        }
        return "fail";
    }
    @GetMapping("/findDepid/{username}")
    public String findDepid(@PathVariable("username") String username){
        Client client = clientRepository.findById(username).get();
        return client.getDepid();
    }
    @GetMapping("/findname/{depid}")
    public List<Client> findname(@PathVariable("depid") String depid){
        List<Client> clients = findAll();
        List<Client> clientList = new ArrayList<>();
        for (Client client : clients){
            if(client.getDepid().equals(depid)){
                clientList.add(client);
            }
        }
        return clientList;
    }
}
