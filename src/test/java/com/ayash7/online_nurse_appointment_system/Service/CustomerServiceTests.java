package com.ayash7.online_nurse_appointment_system.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ayash7.online_nurse_appointment_system.DTO.CustomerDTO;
import com.ayash7.online_nurse_appointment_system.DTO.CustomerRegistrationDTO;
import com.ayash7.online_nurse_appointment_system.Entity.Customer;
import com.ayash7.online_nurse_appointment_system.Repository.CredentialRepository;
import com.ayash7.online_nurse_appointment_system.Repository.CustomerRepository;

@SpringBootTest
public class CustomerServiceTests {
    
    @Test
    void customerServiceRegisterReturnCustomerRegistrationDTO() {
        
        CustomerRegistrationDTO customerRegistrationDTO = CustomerRegistrationDTO.builder().customerUsername("ronaldo7").customerPassword("madrid7").customerName("Cristiano Ronaldo").customerAddress("Portugal").customerContact("777-777777").build();
        
        CustomerRegistrationDTO customer = customerService.registerCustomer(customerRegistrationDTO);
        
        Assertions.assertThat(customerRepository.existsById(customer.getCustomerID()));
        
        customerRepository.deleteById(customer.getCustomerID());
        
        credentialRepository.deleteById(customer.getCustomerUsername());
        
    }
    
    @Test
    void customerServiceUpdateReturnUpdatedCustomerDTO() {
        
        Customer customer = Customer.builder().customerUsername("ramos4").customerName("Sergio Ramos").customerAddress("Spain").customerContact("444-444444").build();
        
        Customer savedCustomer = customerRepository.save(customer);
        
        CustomerDTO customerDTO = CustomerDTO.builder().customerName("Cristiano Ronaldo").customerAddress("Portugal").customerContact("777-777777").build();
        
        CustomerDTO updatedCustomer = customerService.updateCustomer(savedCustomer.getCustomerID(), customerDTO);
        
        Assertions.assertThat(updatedCustomer.getCustomerName()).isEqualTo("Cristiano Ronaldo");
        
        Assertions.assertThat(updatedCustomer.getCustomerAddress()).isEqualTo("Portugal");
        
        Assertions.assertThat(updatedCustomer.getCustomerContact()).isNotEqualTo("444-444444");

        customerRepository.deleteById(updatedCustomer.getCustomerID());
        
    }
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private CredentialRepository credentialRepository;
    
}