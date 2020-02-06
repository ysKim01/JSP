package sec03.ex03;

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


@WebServlet("/session3")
public class SessionTest3 extends HttpServlet {
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
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		out.print("세션 아이디 : " + session.getId() + "<br>");
		out.print("최초 세션 생성 시간 : " + new Date(session.getCreationTime()) + "<br>");
		out.print("최근 세션 접근 시간 : " + new Date(session.getLastAccessedTime()) + "<br>");
		out.print("세션 유효 시간 : " + session.getMaxInactiveInterval() + "초" + "<br>");
		
		if(session.isNew()) {
			out.print("새 세션이 만들어 졌습니다.");
		}
		session.invalidate(); // 생성된 세션 객체를 삭제
		
		
		System.out.println("SessionTest doHandle End");
	}

}
