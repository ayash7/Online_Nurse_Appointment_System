package com.ayash7.online_nurse_appointment_system.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CustomerRegistrationDTO {
    
    private
        
        Integer customerID;
        String customerUsername, customerPassword;
        String customerName, customerAddress, customerContact;
        
}