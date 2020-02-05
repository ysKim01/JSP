package sec02.Quiz01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first2q1")
public class FirstServlet_2Q1 extends HttpServlet {
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
		
		response.addHeader("Refresh", "1;url=second2q1?name=Lee");
		
		System.out.println("FirstServlet Handle End");
	}
}
