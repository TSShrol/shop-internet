package rv.lesson.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rv.lesson.model.User;
import rv.lesson.service.UserService;
import rv.lesson.service.impl.UserServiceImpl;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = UserServiceImpl.getUserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("login");
		String password = request.getParameter("password");

		User user = userService.getUserByEmail(email);

		if (user != null && user.getPassword().equalsIgnoreCase(password)) {
			request.setAttribute("userFirstName", user.getFirstName());
			request.getRequestDispatcher("cabinet.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
}
