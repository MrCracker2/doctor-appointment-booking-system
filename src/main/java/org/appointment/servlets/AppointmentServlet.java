package org.appointment.servlets;

import org.appointment.dao.AppointmentDAO;
import org.appointment.models.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/bookAppointment")
public class AppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        int patientId = Integer.parseInt(request.getParameter("patientId"));
        LocalDate appointmentDate = LocalDate.parse(request.getParameter("appointmentDate"));
        String timeSlot = request.getParameter("timeSlot");

        Appointment appointment = new Appointment(doctorId, patientId, appointmentDate, timeSlot);
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        boolean isBooked = appointmentDAO.addAppointment(appointment);

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            if (isBooked) {
                out.println("<h2>Appointment booked successfully!</h2>");
            } else {
                out.println("<h2>Failed to book the appointment.</h2>");
            }
            out.println("</body></html>");
        }
    }
}
