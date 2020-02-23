package rv.lesson.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rv.lesson.model.User;
import rv.lesson.model.UserRole;
import rv.lesson.service.UserService;
import rv.lesson.service.impl.UserServiceImpl;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet(name = "registration", urlPatterns = { "/registration" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		private UserService userService = UserServiceImpl.getUserService();

		public RegistrationServlet() {
			super();

		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			if (!email.isEmpty() 
					&& !firstName.isEmpty() 
					&& !lastName.isEmpty() 
					&& !password.isEmpty()) {
				User user=new User(email, firstName, lastName, UserRole.USER.toString(), password);
				userService.create(user);
			}

			request.setAttribute("userFirstName", lastName);
			request.getRequestDispatcher("cabinet.jsp").forward(request, response);
			
			
		}

	

}
