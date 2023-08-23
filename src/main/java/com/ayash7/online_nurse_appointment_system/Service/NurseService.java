package com.ayash7.online_nurse_appointment_system.Service;

import com.ayash7.online_nurse_appointment_system.DTO.NurseAdditionDTO;
import com.ayash7.online_nurse_appointment_system.DTO.NurseDTO;

public interface NurseService {
    
    NurseAdditionDTO addNurse(NurseAdditionDTO nurseAdditionDTO);
    
    NurseDTO updateNurse(Integer nurseID, NurseDTO nurseDTO);
    
    void deleteNurse(Integer nurseID);
    
}