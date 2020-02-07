package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login41")
public class LoginServlet41 extends HttpServlet{
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
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}
		
		out.print("<html>");
		out.print("<head><script>");
		out.print("setTimeout('history.go(0);',5000)"); 
		// setTimeout : 5초마다 서블릿에 재요청해서 현재 접속자 수를 표시
		out.print("</script><head>");
		out.print("<body>");
		out.print("아이디 : " + loginUser.user_id + "<br>");
		out.print("총 접속자 수 : " + LoginImpl.total_user + "<br>");
		out.print("</body></html>");
		out.close();
		
		System.out.println("LoginServlet doHandle End");
	}
}
