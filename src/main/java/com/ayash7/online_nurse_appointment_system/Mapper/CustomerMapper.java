package com.ayash7.online_nurse_appointment_system.Mapper;

import com.ayash7.online_nurse_appointment_system.DTO.CustomerDTO;
import com.ayash7.online_nurse_appointment_system.Entity.Customer;

public class CustomerMapper {
    
    public static Customer mapToCustomer(CustomerDTO customerDTO) {
        
        return new Customer(customerDTO.getCustomerID(), customerDTO.getCustomerName(), customerDTO.getCustomerAddress(), customerDTO.getCustomerContact());
        
    }
    
    public static CustomerDTO mapToCustomerDTO(Customer customer) {
        
        return new CustomerDTO(customer.getCustomerID(), customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerContact());
        
    }
    
}