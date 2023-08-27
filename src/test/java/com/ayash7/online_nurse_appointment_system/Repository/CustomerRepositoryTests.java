package com.ayash7.online_nurse_appointment_system.Repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ayash7.online_nurse_appointment_system.Entity.Customer;

@SpringBootTest
public class CustomerRepositoryTests {
    
    @Test
    void customerRepositorySaveReturnSavedCustomer() {
        
        Customer customer = Customer.builder().customerUsername("ronaldo7").customerName("Cristiano Ronaldo").customerAddress("Portugal").customerContact("777-777777").build();
        
        Customer savedCustomer = customerRepository.save(customer);
        
        Assertions.assertThat(savedCustomer).isNotNull();
        
        customerRepository.deleteById(savedCustomer.getCustomerID());
        
    }
    
    @Test
    void customerRepositorySaveIncrementCustomerID() {
        
        Customer customer = Customer.builder().customerUsername("ramos4").customerName("Sergio Ramos").customerAddress("Spain").customerContact("444-444444").build();
        
        Customer savedCustomer = customerRepository.save(customer);
        
        Assertions.assertThat(savedCustomer.getCustomerID()).isGreaterThan(0);
        
        customerRepository.deleteById(savedCustomer.getCustomerID());
        
    }
    
    @Autowired
    private CustomerRepository customerRepository;
    
}