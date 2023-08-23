package com.ayash7.online_nurse_appointment_system.Service;

import com.ayash7.online_nurse_appointment_system.DTO.CheckupDTO;

public interface CheckupService {
    
    CheckupDTO addCheckup(CheckupDTO checkupDTO);
    
    CheckupDTO updateCheckup(Integer checkupID, CheckupDTO checkupDTO);
    
    void deleteCheckup(Integer checkupID);
    
}