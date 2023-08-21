package com.ayash7.online_nurse_appointment_system.Service;

import com.ayash7.online_nurse_appointment_system.DTO.CustomerDTO;

public interface CustomerService {
    
    CustomerDTO addCustomer(CustomerDTO customerDTO);
    
    CustomerDTO updateCustomer(Integer customerID, CustomerDTO customerDTO);
    
    void deleteCustomer(Integer customerID);
    
}