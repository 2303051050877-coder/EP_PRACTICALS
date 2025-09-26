package com.servlets;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDemo")
public class SessionTrackingServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Integer counter = (Integer) session.getAttribute("count");

        if (counter == null) {
            counter = 1;
        } else {
            counter++;
        }
        session.setAttribute("count", counter);

        resp.setContentType("text/html");
        resp.getWriter().println("Session ID: " + session.getId() + "<br>");
        resp.getWriter().println("Visit Count: " + counter);
    }
}
