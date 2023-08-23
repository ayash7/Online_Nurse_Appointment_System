package com.ayash7.online_nurse_appointment_system.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayash7.online_nurse_appointment_system.DTO.CheckupDTO;
import com.ayash7.online_nurse_appointment_system.Service.CheckupService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/api/checkup")
public class CheckupController {
    
    @PostMapping("/add")
    public ResponseEntity<CheckupDTO> addCheckup(@RequestBody CheckupDTO checkupDTO) {
        
        CheckupDTO checkup = checkupService.addCheckup(checkupDTO);
        
        return new ResponseEntity<CheckupDTO>(checkup, HttpStatus.CREATED);
        
    }
    
    @PutMapping("/update/{checkupID}")
    public ResponseEntity<CheckupDTO> updateCheckup(@PathVariable("checkupID") Integer checkupID, @RequestBody CheckupDTO checkupDTO) {
        
        CheckupDTO checkup = checkupService.updateCheckup(checkupID, checkupDTO);
        
        return ResponseEntity.ok(checkup);
        
    }
    
    @DeleteMapping("/delete/{checkupID}")
    public ResponseEntity<String> deleteCheckup(@PathVariable("checkupID") Integer checkupID) {
        
        checkupService.deleteCheckup(checkupID);
        
        return ResponseEntity.ok("checkupID: " + checkupID + " | Status: Checkup successfully deleted from database.");
        
    }
    
    private CheckupService checkupService;
    
}