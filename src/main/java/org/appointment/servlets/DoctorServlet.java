package org.appointment.servlets;

import org.appointment.dao.DoctorDAO;
import org.appointment.models.Doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/listDoctors")
public class DoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        DoctorDAO doctorDAO = new DoctorDAO();
        List<Doctor> doctors = doctorDAO.getAllDoctors();

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h2>Available Doctors</h2>");
            out.println("<ul>");
            for (Doctor doctor : doctors) {
                out.println("<li>" + doctor.getName() + " - " + doctor.getSpecialization() + "</li>");
            }
            out.println("</ul>");
            out.println("</body></html>");
        }
    }
}
