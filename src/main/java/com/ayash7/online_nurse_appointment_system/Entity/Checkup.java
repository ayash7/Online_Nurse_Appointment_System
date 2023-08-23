package com.ayash7.online_nurse_appointment_system.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Checkup")
public class Checkup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkupID")
    private Integer checkupID;
    
    @Column(name = "checkupDescription")
    private String checkupDescription;
    
    @Column(name = "checkupCharge")
    private Double checkupCharge;
    
}