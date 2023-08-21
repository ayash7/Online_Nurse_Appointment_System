package com.ayash7.online_nurse_appointment_system.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayash7.online_nurse_appointment_system.DTO.CustomerDTO;
import com.ayash7.online_nurse_appointment_system.Service.CustomerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerController {
    
    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        
        CustomerDTO customer = customerService.addCustomer(customerDTO);
        
        return new ResponseEntity<CustomerDTO>(customer, HttpStatus.CREATED);
        
    }
    
    @PutMapping("{customerID}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("customerID") Integer customerID, @RequestBody CustomerDTO customerDTO) {
        
        CustomerDTO customer = customerService.updateCustomer(customerID, customerDTO);
        
        return ResponseEntity.ok(customer);
        
    }
    
    @DeleteMapping("{customerID}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerID") Integer customerID) {
        
        customerService.deleteCustomer(customerID);
        
        return ResponseEntity.ok("Status: Customer successfully deleted from database.");
        
    }
    
    private CustomerService customerService;
    
}