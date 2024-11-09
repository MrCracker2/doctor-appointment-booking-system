package org.appointment.dao;

import org.appointment.models.Appointment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public boolean addAppointment(Appointment appointment) {
        String query = "INSERT INTO Appointment (doctor_id, patient_id, appointment_date, time_slot) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, appointment.getDoctorId());
            pstmt.setInt(2, appointment.getPatientId());
            pstmt.setDate(3, Date.valueOf(appointment.getDate()));
            pstmt.setString(4, appointment.getTimeSlot());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM Appointment";

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int appointmentId = rs.getInt("appointment_id");
                int doctorId = rs.getInt("doctor_id");
                int patientId = rs.getInt("patient_id");
                Date date = rs.getDate("appointment_date");
                String timeSlot = rs.getString("time_slot");

                Appointment appointment = new Appointment(appointmentId, doctorId, patientId, date.toString(), timeSlot);
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }
}
