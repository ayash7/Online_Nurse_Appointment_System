package com.ayash7.online_nurse_appointment_system.Mapper;

import com.ayash7.online_nurse_appointment_system.DTO.CheckupDTO;
import com.ayash7.online_nurse_appointment_system.Entity.Checkup;

public class CheckupMapper {
    
    public static Checkup mapToCheckup(CheckupDTO checkupDTO) {
        
        return new Checkup(checkupDTO.getCheckupID(), checkupDTO.getCheckupDescription(), checkupDTO.getCheckupCharge());
        
    }
    
    public static CheckupDTO mapToCheckupDTO(Checkup checkup) {
        
        return new CheckupDTO(checkup.getCheckupID(), checkup.getCheckupDescription(), checkup.getCheckupCharge());
        
    }
    
}