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

@WebServlet("/cset")
public class SetservletContext extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("SetservletContext Init");
	}
	public void destroy() {
		System.out.println("SetservletContext Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SetservletContext doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SetservletContext doPost");
		doHandle(request, response);
	}

	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SetservletContext doHandle Start");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		
		List member = new ArrayList();
		member.add("이순신");
		member.add(30);
		context.setAttribute("member", member);
		
		out.print("<html><body>");
		out.print("이순신과 30 설정");
		out.print("</body></html>");
		
		System.out.println("SetservletContext doHandle End");
	}
}
