package com.ayash7.online_nurse_appointment_system.Service;

import com.ayash7.online_nurse_appointment_system.DTO.AdminDTO;

public interface AdminService {
    
    AdminDTO registerAdmin(AdminDTO adminDTO);
    
    void deleteAdmin(String adminUsername);
    
}