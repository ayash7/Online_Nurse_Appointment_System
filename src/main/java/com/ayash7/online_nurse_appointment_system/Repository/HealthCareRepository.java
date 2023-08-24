package com.ayash7.online_nurse_appointment_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayash7.online_nurse_appointment_system.Entity.HealthCare;

public interface HealthCareRepository extends JpaRepository<HealthCare, Integer> {}