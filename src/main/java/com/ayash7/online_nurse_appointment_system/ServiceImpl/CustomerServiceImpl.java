package com.ayash7.online_nurse_appointment_system.ServiceImpl;

import org.springframework.stereotype.Service;

import com.ayash7.online_nurse_appointment_system.ResourceNotFoundException;
import com.ayash7.online_nurse_appointment_system.DTO.CustomerDTO;
import com.ayash7.online_nurse_appointment_system.Entity.Customer;
import com.ayash7.online_nurse_appointment_system.Mapper.CustomerMapper;
import com.ayash7.online_nurse_appointment_system.Repository.CustomerRepository;
import com.ayash7.online_nurse_appointment_system.Service.CustomerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    
    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        
        Customer customer = CustomerMapper.mapToCustomer(customerDTO);
        
        Customer addedCustomer = customerRepository.save(customer);
        
        return CustomerMapper.mapToCustomerDTO(addedCustomer);
        
    }
    
    @Override
    public CustomerDTO updateCustomer(Integer customerID, CustomerDTO customerDTO) {
        
        Customer customer = customerRepository.findById(customerID).orElseThrow(
            
            () -> new ResourceNotFoundException("customerID: " + customerID + " | Status: Customer not present in database.")
            
        );
        
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerAddress(customerDTO.getCustomerAddress());
        customer.setCustomerContact(customerDTO.getCustomerContact());
        
        Customer updatedCustomer = customerRepository.save(customer);
        
        return CustomerMapper.mapToCustomerDTO(updatedCustomer);
        
    }
    
    @Override
    public void deleteCustomer(Integer customerID) {
        
        customerRepository.findById(customerID).orElseThrow(
            
            () -> new ResourceNotFoundException("customerID: " + customerID + " | Status: Customer not present in database.")
            
        );
        
        customerRepository.deleteById(customerID);
        
    }
    
    private CustomerRepository customerRepository;
    
}