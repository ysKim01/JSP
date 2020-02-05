package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cget")
public class GetservletContext extends HttpServlet {
	
	public void init() throws ServletException {
		System.out.println("SetservletContext Init");
	}
	public void destroy() {
		System.out.println("SetservletContext Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetservletContext doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetservletContext doPost");
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetservletContext doHandle Start");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		List member = (ArrayList)context.getAttribute("member");
		
		String name = (String)member.get(0);
		int age = (Integer)member.get(1);
		
		out.print("<html><body>");
		out.print("이름 : " + name + "<br>");
		out.print("나이 : " + age + "<br>");
		out.print("</body></html>");
		
		System.out.println("GetservletContext doHandle End");
	}

}
