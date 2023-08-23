package com.ayash7.online_nurse_appointment_system.Mapper;

import com.ayash7.online_nurse_appointment_system.DTO.NurseAdditionDTO;
import com.ayash7.online_nurse_appointment_system.DTO.NurseDTO;
import com.ayash7.online_nurse_appointment_system.Entity.Credential;
import com.ayash7.online_nurse_appointment_system.Entity.Nurse;

public class NurseMapper {
    
    public static Nurse mapToNurse(NurseAdditionDTO nurseAdditionDTO) {
        
        return new Nurse(nurseAdditionDTO.getNurseID(), nurseAdditionDTO.getNurseUsername(), nurseAdditionDTO.getNurseName(), nurseAdditionDTO.getNurseAddress(), nurseAdditionDTO.getNurseContact());
        
    }
    
    public static Credential mapToNurseCredential(NurseAdditionDTO nurseAdditionDTO) {
        
        return new Credential(nurseAdditionDTO.getNurseUsername(), nurseAdditionDTO.getNursePassword(), "NURSE");
        
    }
    
    public static NurseAdditionDTO mapToNurseAdditionDTO(Nurse nurse, Credential nurseCredential) {
        
        return new NurseAdditionDTO(nurse.getNurseID(), nurseCredential.getEntityUsername(), nurseCredential.getEntityPassword(), nurse.getNurseName(), nurse.getNurseAddress(), nurse.getNurseContact());
        
    }
    
    public static Nurse mapToNurse(NurseDTO nurseDTO, String nurseUsername) {
        
        return new Nurse(nurseDTO.getNurseID(), nurseUsername, nurseDTO.getNurseName(), nurseDTO.getNurseAddress(), nurseDTO.getNurseContact());
        
    }
    
    public static NurseDTO mapToNurseDTO(Nurse nurse) {
        
        return new NurseDTO(nurse.getNurseID(), nurse.getNurseName(), nurse.getNurseAddress(), nurse.getNurseContact());
        
    }
    
}