package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sess")
public class SessionTest extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		session.setAttribute("name", "myName");
		
		out.print("<html><body>");
		out.print("<h1>세션에 이름을 바인딩합니다.</h1>");
		out.print("<a href='/pro08/test01/session1.jsp'>첫번째 페이지로 이동하기</a>");
		out.print("</body></html>");
	}

}
