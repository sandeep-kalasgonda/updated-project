package com.example.Project.service;

import com.example.Project.entity.Appointment;
import com.example.Project.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

  @Autowired
  private AppointmentRepository appointmentRepository;

  public List<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
  }

  public Optional<Appointment> getAppointmentById(Long id) {
    return appointmentRepository.findById(id);
  }

  public Appointment saveAppointment(Appointment appointment) {
    return appointmentRepository.save(appointment);
  }

  public void deleteAppointment(Long id) {
    appointmentRepository.deleteById(id);
  }

  public List<Appointment> getAppointmentsByDate(LocalDate date) {
    return appointmentRepository.findByAppointmentDate(date);
  }
}
