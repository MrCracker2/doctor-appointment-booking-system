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
import java.util.List;

@WebServlet("/viewAppointments")
public class ViewAppointmentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;  // Added serialVersionUID

    private AppointmentDAO appointmentDAO;

    @Override
    public void init() throws ServletException {
        appointmentDAO = new AppointmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Appointment> appointments = appointmentDAO.getAllAppointments();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>All Appointments</h2>");
        
        for (Appointment appointment : appointments) {
            out.println("<p>" + appointment.toString() + "</p>");
        }

        out.println("</body></html>");
    }
}
