package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session4")
public class SessionTest4 extends HttpServlet {
	public void init() throws ServletException {
		System.out.println("SessionTest Init");
	}
	public void destroy() {
		System.out.println("SessionTest Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SessionTest doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SessionTest doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SessionTest doHandle Start");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		out.print("세션 아이디 : " + session.getId() + "<br>");
		if(session.isNew()) {
			if(user_id!=null && user_id.length()!=0) {
				session.setAttribute("user_id", user_id);
				out.print("<a href='session4'>로그인 상태 확인</a>");
			}else {
				out.print("<a href='login2.html'>다시 로그인 하세요.1</a>");
			}
		}else {
			user_id = (String)session.getAttribute("user_id");
			if(user_id!=null && user_id.length()!=0) {
				out.print("반갑습니다. " + user_id + "님");
			}else {
				out.print("<a href='login2.html'>다시 로그인 하세요.2</a>");
				session.invalidate();
			}
		}
		
		
		System.out.println("SessionTest doHandle End");
	}

}
