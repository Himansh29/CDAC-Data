package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class signup
 */
@WebServlet(value = "/register", loadOnStartup = 1)

public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDaoImpl userDao;

	@Override
	public void init() throws ServletException {
		try {
			userDao = new UserDaoImpl();

		} catch (Exception e) {

			throw new ServletException("err in init" + getClass(), e);

		}

	}

	@Override
	public void destroy() {

		try {
			userDao.cleanUp();
		} catch (Exception e) {
			System.out.println("destroyed");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String dob = request.getParameter("dob");
			
			User user;
			
			LocalDate localDate = LocalDate.parse(dob);
			LocalDate todaysDate = LocalDate.now();
			
			Period period = Period.between(localDate, todaysDate);
			
			
			if(period.getYears() >= 21) {
				user = new User(firstName, lastName, email, pass, Date.valueOf(dob));
				userDao.voterRegistration(user);
				response.sendRedirect("login.html");
				System.out.println("registration succesfull");
			}else {
				pw.print("<h2> <a href='login.html'> Click here to login </a> </h2>");
			}
			//pw.print("<h5>Successful login <a href='login.html'>click here to again login</a></h5>");
			System.out.println("registration succesfull");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
