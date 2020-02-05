package sec02.ex01_getParam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first5")
public class FirstServlet5 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet Init");
	}
	public void destroy() {
		System.out.println("FirstServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet Handle Start");
		response.setContentType("text/html;charset=utf-8");
		
		// Redirect로 값 전달하기 - get방식 
		response.sendRedirect("second5?name=Lee");
		
		System.out.println("FirstServlet Handle End");
	}
}
