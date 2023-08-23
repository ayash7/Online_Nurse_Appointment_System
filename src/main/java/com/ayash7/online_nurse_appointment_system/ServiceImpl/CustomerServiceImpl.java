package com.ayash7.online_nurse_appointment_system.ServiceImpl;

import org.springframework.stereotype.Service;

import com.ayash7.online_nurse_appointment_system.Authentication.PasswordEncoder;
import com.ayash7.online_nurse_appointment_system.DTO.CustomerAdditionDTO;
import com.ayash7.online_nurse_appointment_system.DTO.CustomerDTO;
import com.ayash7.online_nurse_appointment_system.Entity.Credential;
import com.ayash7.online_nurse_appointment_system.Entity.Customer;
import com.ayash7.online_nurse_appointment_system.Exception.DuplicateResourceFoundException;
import com.ayash7.online_nurse_appointment_system.Exception.ResourceNotFoundException;
import com.ayash7.online_nurse_appointment_system.Mapper.CustomerMapper;
import com.ayash7.online_nurse_appointment_system.Repository.CredentialRepository;
import com.ayash7.online_nurse_appointment_system.Repository.CustomerRepository;
import com.ayash7.online_nurse_appointment_system.Service.CustomerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    
    @Override
    public CustomerAdditionDTO addCustomer(CustomerAdditionDTO customerAdditionDTO) {
        
        Customer customer = CustomerMapper.mapToCustomer(customerAdditionDTO);
        
        Credential credential = CustomerMapper.mapToCustomerCredential(customerAdditionDTO);
        
        if(credentialRepository.existsById(credential.getEntityUsername())) throw new DuplicateResourceFoundException("customerUsername: " + credential.getEntityUsername() + " | Status: Username already present in database.");
        
        String customerPassword = credential.getEntityPassword();
        
        credential.setEntityPassword(PasswordEncoder.encodePassword(customerPassword));
        
        Customer addedCustomer = customerRepository.save(customer);
        
        Credential addedCredential = credentialRepository.save(credential);
        
        addedCredential.setEntityPassword(customerPassword);
        
        return CustomerMapper.mapToCustomerAdditionDTO(addedCustomer, addedCredential);
        
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
    
    private
        
        CustomerRepository customerRepository;
        CredentialRepository credentialRepository;
    
}