package org.appointment.dao;

import org.appointment.models.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM Doctor";

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int doctorId = rs.getInt("doctor_id");
                String name = rs.getString("name");
                String specialization = rs.getString("specialization");

                Doctor doctor = new Doctor(doctorId, name, specialization);
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }
}
