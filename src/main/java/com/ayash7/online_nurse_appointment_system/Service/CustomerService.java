package com.ayash7.online_nurse_appointment_system.Service;

import com.ayash7.online_nurse_appointment_system.DTO.CustomerAdditionDTO;
import com.ayash7.online_nurse_appointment_system.DTO.CustomerDTO;

public interface CustomerService {
    
    CustomerAdditionDTO addCustomer(CustomerAdditionDTO customerAdditionDTO);
    
    CustomerDTO updateCustomer(Integer customerID, CustomerDTO customerDTO);
    
    void deleteCustomer(Integer customerID);
    
}