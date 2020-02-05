package sec02.Quiz01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second2q1")
public class SecondServlet_2Q1 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("SecondServlet Init");
	}
	public void destroy() {
		System.out.println("SecondServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SecondServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SecondServlet doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SecondServlet Handle Start");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");

		out.print("<html><body>");
		out.print("Refresh<br>");
		out.print("¿Ã∏ß : " + name);
		out.print("</html></body>");
		
		System.out.println("SecondServlet Handle End");
	}
}
