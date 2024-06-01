import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class FirstServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Inside init:" + Thread.currentThread());
	}

	@Override
	public void destroy() {
		System.out.println("Inside Destroy:" + Thread.currentThread());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		try (PrintWriter pw = resp.getWriter()) {
			pw.print("<h2> Hello from servlet: " + LocalTime.now() + "</h2>");
		}
	}
	

}
