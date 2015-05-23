package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter put = response.getWriter();
		String globalId = this.getServletConfig().getServletContext()
				.getInitParameter("email");
		String message = (String) this.getServletConfig().getServletContext()
				.getAttribute("message");
		if (session == null) {
			response.sendRedirect("login.html");
		} else {
			String color = "cyan";
			Cookie c[] = request.getCookies();
			if (c != null && c.length > 0) {
				for (Cookie temp : c) {
					if (temp.getName().equals("favcolor")) {
						color = temp.getValue();
						break;

					}
				}
			}
			String userid = (String) session.getAttribute("user-id");
			put.print("Welcome " + userid + color + "\n" + globalId);
			put.print("\nMessage is :" + message);
		}
	}

}
