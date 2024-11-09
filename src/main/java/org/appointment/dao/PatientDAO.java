package org.appointment.dao;

import org.appointment.models.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAO {

    public boolean addPatient(Patient patient) {
        String query = "INSERT INTO Patient (name, contact) VALUES (?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, patient.getName());
            pstmt.setString(2, patient.getContact());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
