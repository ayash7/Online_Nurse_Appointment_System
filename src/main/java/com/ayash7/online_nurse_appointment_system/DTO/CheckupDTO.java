package com.ayash7.online_nurse_appointment_system.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CheckupDTO {
    
    private
        
        Integer checkupID;
        String checkupDescription;
        Double checkupCharge;
        
}