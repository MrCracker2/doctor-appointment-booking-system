package org.appointment.models;

public class Patient {
    private String name;
    private String contact;

    // Constructor to initialize the patient's name and contact
    public Patient(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    // Getter for the patient's name
    public String getName() {
        return name;
    }

    // Getter for the patient's contact information
    public String getContact() {
        return contact;
    }
}
