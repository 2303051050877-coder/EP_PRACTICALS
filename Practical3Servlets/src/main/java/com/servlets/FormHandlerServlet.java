package com.servlets;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formHandler")
public class FormHandlerServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("username");
        String age = req.getParameter("age");

        out.println("<h2>Form Submitted Successfully!</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Age: " + age);
    }
}
