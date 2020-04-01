package session.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		writer.print("<h2>This is the Electricity Bill for Consumer Number: " + session.getAttribute("consumerNum") + "</h2><br/>");
		writer.print("Unit Consumed: " + session.getAttribute("UnitsConsumed") + "<br/>");
		writer.print("Net Amount: Rs." + session.getAttribute("NetAmount") + "<br/>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String customerNum = request.getParameter("consumerNum");
		double lastMonth = Double.parseDouble(request.getParameter("lastMonth"));
		double currentMonth = Double.parseDouble(request.getParameter("currentMonth"));
		double unitConsumed = currentMonth - lastMonth;
		double netAmount = unitConsumed * 1.15 + 100;
		session.setAttribute("consumerNum", customerNum);
		session.setAttribute("currentMonth", currentMonth);
		session.setAttribute("UnitsConsumed", unitConsumed);
		session.setAttribute("NetAmount", netAmount);
		
		doGet(request, response);
	}

}
