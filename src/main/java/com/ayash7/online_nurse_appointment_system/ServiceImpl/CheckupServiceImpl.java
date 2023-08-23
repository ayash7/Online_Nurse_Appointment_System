package com.ayash7.online_nurse_appointment_system.ServiceImpl;

import org.springframework.stereotype.Service;

import com.ayash7.online_nurse_appointment_system.DTO.CheckupDTO;
import com.ayash7.online_nurse_appointment_system.Entity.Checkup;
import com.ayash7.online_nurse_appointment_system.Exception.ResourceNotFoundException;
import com.ayash7.online_nurse_appointment_system.Mapper.CheckupMapper;
import com.ayash7.online_nurse_appointment_system.Repository.CheckupRepository;
import com.ayash7.online_nurse_appointment_system.Service.CheckupService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CheckupServiceImpl implements CheckupService {
    
    @Override
    public CheckupDTO addCheckup(CheckupDTO checkupDTO) {
        
        Checkup checkup = CheckupMapper.mapToCheckup(checkupDTO);
        
        Checkup addedCheckup = checkupRepository.save(checkup);
        
        return CheckupMapper.mapToCheckupDTO(addedCheckup);
        
    }
    
    @Override
    public CheckupDTO updateCheckup(Integer checkupID, CheckupDTO checkupDTO) {
        
        Checkup checkup = checkupRepository.findById(checkupID).orElseThrow(
            
            () -> new ResourceNotFoundException("checkupID: " + checkupID + " | Status: Checkup not present in database.")
            
        );
        
        checkup.setCheckupDescription(checkupDTO.getCheckupDescription());
        checkup.setCheckupCharge(checkupDTO.getCheckupCharge());
        
        Checkup updatedCheckup = checkupRepository.save(checkup);
        
        return CheckupMapper.mapToCheckupDTO(updatedCheckup);
        
    }
    
    @Override
    public void deleteCheckup(Integer checkupID) {
        
        checkupRepository.findById(checkupID).orElseThrow(
            
            () -> new ResourceNotFoundException("checkupID: " + checkupID + " | Status: Checkup not present in database.")
            
        );
        
        checkupRepository.deleteById(checkupID);
        
    }
    
    private CheckupRepository checkupRepository;
    
}