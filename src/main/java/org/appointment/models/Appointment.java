package org.appointment.models;

import java.time.LocalDate;

public class Appointment {
    private int appointmentId;
    private int doctorId;
    private int patientId;
    private LocalDate date;
    private String timeSlot;

    // Constructor for AppointmentDAO needs (int, int, int, String, String)
    public Appointment(int appointmentId, int doctorId, int patientId, String date, String timeSlot) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = LocalDate.parse(date); // Parse date from String to LocalDate
        this.timeSlot = timeSlot;
    }

    // Other constructors, getters, and setters
    public Appointment(int doctorId, int patientId, LocalDate date, String timeSlot) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
        this.timeSlot = timeSlot;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}
