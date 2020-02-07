package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout42")
public class LogoutServlet42 extends HttpServlet{
	
	ServletContext context;
	
	public void init() throws ServletException {
		System.out.println("LogoutServlet Init");
	}
	public void destroy() {
		System.out.println("LogoutServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LogoutServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LogoutServlet doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LogoutServlet doHandle Start");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		context = getServletContext();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		
		session.invalidate();
		
		List user_list = (ArrayList)context.getAttribute("user_list");
		user_list.remove(user_id);
		context.removeAttribute("user_list");
		context.setAttribute("user_list", user_list);
		
		out.print("<html><body>");
		out.print("<br> 로그아웃 되었습니다.");
		out.print("</body></html>");
		out.close();
		
		System.out.println("LogoutServlet doHandle End");
	}
}
