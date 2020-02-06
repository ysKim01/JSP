package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	public void init() throws ServletException {
		System.out.println("SetCookieValue Init");
	}
	public void destroy() {
		System.out.println("SetCookieValue Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SetCookieValue doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SetCookieValue doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SetCookieValue doHandle Start");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		
		Cookie c = new Cookie("cookieTest", 
				URLEncoder.encode("JSP프로그래밍","utf-8"));
		//c.setMaxAge(24*60*60); // 하루 (초단위)
		c.setMaxAge(-1); // 유효시간을 음수로 지정하면 Session쿠키로 만들 수 있다. 양수는 Persistance쿠키
		response.addCookie(c);
		
		out.print("현재시간 : " + d);
		out.print("<br>문자열을 Cookie에 저장합니다.");
		
		System.out.println("SetCookieValue doHandle End");
	}

}
