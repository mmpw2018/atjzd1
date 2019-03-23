package atj;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(asyncSupported = true, description = "Moj serwlecik", urlPatterns = { "/MyServlet" })
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double value1;
	double result;
	String oper;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		value1 = Double.parseDouble(request.getParameter("value1"));
		oper =request.getParameter("oper");
		calculate(value1, oper);
	
		request.setAttribute("result", Double.valueOf(result));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Konwerter.jsp");
		requestDispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	
	
	private void calculate ( double value1, String oper){
	if (oper.equals("ConF")) result = (9*value1/5)+32;
	else if (oper.equals("FonC")) result = 5*(value1-32)/9;
	}
}
