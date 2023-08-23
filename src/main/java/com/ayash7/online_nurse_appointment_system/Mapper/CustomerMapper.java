package com.ayash7.online_nurse_appointment_system.Mapper;

import com.ayash7.online_nurse_appointment_system.DTO.CustomerAdditionDTO;
import com.ayash7.online_nurse_appointment_system.DTO.CustomerDTO;
import com.ayash7.online_nurse_appointment_system.Entity.Credential;
import com.ayash7.online_nurse_appointment_system.Entity.Customer;

public class CustomerMapper {
    
    public static Customer mapToCustomer(CustomerAdditionDTO customerAdditionDTO) {
        
        return new Customer(customerAdditionDTO.getCustomerID(), customerAdditionDTO.getCustomerUsername(), customerAdditionDTO.getCustomerName(), customerAdditionDTO.getCustomerAddress(), customerAdditionDTO.getCustomerContact());
        
    }
    
    public static Credential mapToCustomerCredential(CustomerAdditionDTO customerAdditionDTO) {
        
        return new Credential(customerAdditionDTO.getCustomerUsername(), customerAdditionDTO.getCustomerPassword(), "CUSTOMER");
        
    }
    
    public static CustomerAdditionDTO mapToCustomerAdditionDTO(Customer customer, Credential customerCredential) {
        
        return new CustomerAdditionDTO(customer.getCustomerID(), customerCredential.getEntityUsername(), customerCredential.getEntityPassword(), customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerContact());
        
    }
    
    public static Customer mapToCustomer(CustomerDTO customerDTO, String customerUsername) {
        
        return new Customer(customerDTO.getCustomerID(), customerUsername, customerDTO.getCustomerName(), customerDTO.getCustomerAddress(), customerDTO.getCustomerContact());
        
    }
    
    public static CustomerDTO mapToCustomerDTO(Customer customer) {
        
        return new CustomerDTO(customer.getCustomerID(), customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerContact());
        
    }
    
}