package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class GetCookieValue extends HttpServlet {
	public void init() throws ServletException {
		System.out.println("GetCookieValue Init");
	}
	public void destroy() {
		System.out.println("GetCookieValue Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetCookieValue doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetCookieValue doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetCookieValue doHandle Start");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] allValues = request.getCookies();
		// ��Ű������ ��û�� �Ŀ� ��Ű������ �����´�.
		for(int i=0;i<allValues.length;i++) {
			if(allValues[i].getName().equals("cookieTest")) {
				out.print("<h2>Cookie �� �������� : " + URLDecoder.decode(allValues[i].getValue(),"utf-8"));
			}
		}
		
		System.out.println("GetCookieValue doHandle End");
	}
}
