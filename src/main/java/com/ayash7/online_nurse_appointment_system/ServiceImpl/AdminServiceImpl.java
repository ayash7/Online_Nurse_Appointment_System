package com.ayash7.online_nurse_appointment_system.ServiceImpl;

import org.springframework.stereotype.Service;

import com.ayash7.online_nurse_appointment_system.Authentication.PasswordEncoder;
import com.ayash7.online_nurse_appointment_system.DTO.AdminDTO;
import com.ayash7.online_nurse_appointment_system.Entity.Credential;
import com.ayash7.online_nurse_appointment_system.Exception.DuplicateResourceFoundException;
import com.ayash7.online_nurse_appointment_system.Exception.ResourceNotFoundException;
import com.ayash7.online_nurse_appointment_system.Mapper.AdminMapper;
import com.ayash7.online_nurse_appointment_system.Repository.CredentialRepository;
import com.ayash7.online_nurse_appointment_system.Service.AdminService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    
    @Override
    public AdminDTO registerAdmin(AdminDTO adminDTO) {
        
        Credential credential = AdminMapper.mapToCredential(adminDTO);
        
        if(credentialRepository.existsById(credential.getEntityUsername())) throw new DuplicateResourceFoundException("adminUsername: " + credential.getEntityUsername() + " | Error: Username already present in database.");
        
        String adminPassword = credential.getEntityPassword();
        
        credential.setEntityPassword(PasswordEncoder.encodePassword(adminPassword));
        
        Credential registeredCredential = credentialRepository.save(credential);
        
        registeredCredential.setEntityPassword(adminPassword);
        
        return AdminMapper.mapToAdminDTO(registeredCredential);
        
    }
    
    @Override
    public void deleteAdmin(String adminUsername) {
        
        if(!(credentialRepository.existsById(adminUsername) && credentialRepository.findById(adminUsername).get().getEntityRole().equals("ADMIN"))) throw new ResourceNotFoundException("adminUsername: " + adminUsername + " | Error: Admin not present in database.");
        
        credentialRepository.deleteById(adminUsername);
        
    }
    
    private CredentialRepository credentialRepository;
    
}