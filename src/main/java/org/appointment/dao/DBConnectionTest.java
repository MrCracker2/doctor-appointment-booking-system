package org.appointment.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {
    public static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Connection successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
