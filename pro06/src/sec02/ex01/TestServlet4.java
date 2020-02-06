package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/*") // 확장자만 일치하는 URL 패턴 > 웹띄우고 url에 *에 아무거나 입력해도 똑같음
public class TestServlet4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath(); // context 이름
		String url = request.getRequestURL().toString(); // 전체 url
		String mapping = request.getServletPath(); // servlet mapping 이름
		String uri = request.getRequestURI().toString(); // 전체 uri
		
		out.print("<html>");
		out.print("<head><title>test Servlet4</title></head>");
		out.print("<body bgcolor='lightblue'>");
		out.print("<b>Test Servlet4 입니다.<b><br>");
		out.print("<b>context : " + context + "<b><br>");
		out.print("<b>전체경로 : " + url + "<b><br>");
		out.print("<b>매핑 명 : " + mapping + "<b><br>");
		out.print("<b>URI : " + uri + "<b><br>");
		out.print("</body></html>");
		out.close();
	}

}








