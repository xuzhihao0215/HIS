package com.hospital.hisspring.controller;

import com.hospital.hisspring.entity.Invoice;
import com.hospital.hisspring.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceHandler {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping("/findAll")
    public List<Invoice> findAll(){
        return invoiceRepository.findAll();
    }
    @PostMapping("/save")
    public void save(@RequestBody Invoice invoice){
        invoice.setDate(new Date());
        invoiceRepository.save(invoice);
    }
    @GetMapping("/findByBLH/{medicalrecordno}")
    public List<Invoice> findByBLH(@PathVariable("medicalrecordno") String medicalrecordno){
        List<Invoice> invoices = findAll();
        List<Invoice> invoiceList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sdf.format(new Date());
        for (Invoice invoice : invoices){
            if (invoice.getMedicalrecordno().equals(medicalrecordno) && sdf.format(invoice.getDate()).equals(newDate)){
                invoiceList.add(invoice);
            }
        }
        return invoiceList;
    }
    @PostMapping("/update")
    public String update(@RequestBody List<Invoice> invoices){
        int count = 0;
        for(Invoice invoice : invoices){
            if(invoice.getPaystate().equals("n")){
                invoice.setPaystate("y");
                invoiceRepository.save(invoice);
                count++;
            }
        }
        if(count > 0){
            return "paysuccess";
        }else{
            return "payfail";
        }

    }
}
