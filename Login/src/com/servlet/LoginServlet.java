package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String brach = request.getParameter("branch");
		String mailId = this.getServletConfig().getInitParameter("email");
		String globalId = this.getServletConfig().getServletContext()
				.getInitParameter("email");
		String message = (String) this.getServletConfig().getServletContext()
				.getAttribute("message");
		System.out.println(userid + password);
		if (userid != null && password != null) {
			if (userid.equals(password)) {
				String color = request.getParameter("bcolor");
				Cookie cookie[] = request.getCookies();
				if (!(cookie != null && cookie.length > 0)) {
					Cookie c = new Cookie("favcolor", color);
					c.setMaxAge(24 * 60 * 60);
					response.addCookie(c);
				}
				HttpSession session = request.getSession(true);
				session.setAttribute("user-id", userid);
				PrintWriter out = response.getWriter();
				request.getRequestDispatcher("/header").include(request,
						response);
				out.print("<html><body>Welcome " + userid + "<br>Branch "
						+ brach + "<br>Email is :" + mailId);
				out.print("<br> Global Id :" + globalId + "<br>Message is "
						+ message + "</body></html>");

			}
		}
	}

}
