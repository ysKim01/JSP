package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sec05.ex01.MemberVO;


@WebServlet("/show")
public class ShowServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("ShowServlet Init");
	}
	public void destroy() {
		System.out.println("ShowServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ShowServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ShowServlet doPost");
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ShowServlet Start");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = "";
		String pw = "";
		Boolean isLogon = false;
		HttpSession session = request.getSession(false);
		
		if(session!=null) {  
			isLogon = (Boolean)session.getAttribute("isLogon");
			if(isLogon) {
				id = (String)session.getAttribute("login.id");
				pw = (String)session.getAttribute("login.pw");
				out.print("<html><body>");
				out.print("아이디 : " + id + "<br>");
				out.print("패스워드 : " + pw + "<br>");
				out.print("</body></html>");
			}else {
				response.sendRedirect("login3.html");
			}
		}else {
			response.sendRedirect("login3.html");
		}
		
		System.out.println("ShowServlet End");
	}

}








