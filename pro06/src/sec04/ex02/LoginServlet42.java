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

@WebServlet("/login42")
public class LoginServlet42 extends HttpServlet{
	
	ServletContext context = null;
	List user_list = new ArrayList();
	
	public void init() throws ServletException {
		System.out.println("LoginServlet Init");
	}
	public void destroy() {
		System.out.println("LoginServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doHandle Start");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		context = getServletContext();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl42 loginUser = new LoginImpl42(user_id, user_pw);
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}
		
		out.print("<html>");
		out.print("<head>");
		out.print("<body>");
		out.print("아이디 : " + loginUser.user_id + "<br>");
		out.print("총 접속자 수 : " + LoginImpl42.total_user + "<br>");
		out.print("[접속 아이디] <br> ");
		List list = (ArrayList)context.getAttribute("user_list");
		for(int i=0;i<list.size();i++) {
			out.print(list.get(i) + "<br>");
		}
		out.print("<a href='logout42?user_id='"+user_id+"'>로그아웃</a>");
		out.print("</body></html>");
		out.close();
		
		System.out.println("LoginServlet doHandle End");
	}
}
