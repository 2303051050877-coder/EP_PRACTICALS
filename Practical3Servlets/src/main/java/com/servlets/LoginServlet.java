package com.servlets;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if ("shivansh mishra".equals(user) && "1234".equals(pass)) {
            out.println("<h2>✅ Login Successful</h2>");
        } else {
            out.println("<h2>❌ Invalid Username or Password</h2>");
        }
    }
}
