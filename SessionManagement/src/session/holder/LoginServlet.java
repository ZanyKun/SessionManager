package session.holder;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		if(username.equals("") && password.equals("")) {
			writer.print("<h2>Please enter a username and password.</h2><br/>" +
		"<a href='/SessionManagement/login.html'>Back to Log In Page</a>");
		}
		else if(!username.equals("admin") || !password.equals("password")) {
			writer.print("<h2>You have entered an incorrect username and password.</h2><br/>" +
					"<a href='/SessionManagement/login.html'>Back to Log In Page</a>");
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/adminpage.html");
			dispatcher.forward(request, response);
		}
	}

}
