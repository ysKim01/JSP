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
				URLEncoder.encode("JSP���α׷���","utf-8"));
		//c.setMaxAge(24*60*60); // �Ϸ� (�ʴ���)
		c.setMaxAge(-1); // ��ȿ�ð��� ������ �����ϸ� Session��Ű�� ���� �� �ִ�. ����� Persistance��Ű
		response.addCookie(c);
		
		out.print("����ð� : " + d);
		out.print("<br>���ڿ��� Cookie�� �����մϴ�.");
		
		System.out.println("SetCookieValue doHandle End");
	}

}
