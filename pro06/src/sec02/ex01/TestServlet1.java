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

//@WebServlet("/first/test") // 정확하게 이름까지 일치하는 URL 패턴
public class TestServlet1 extends HttpServlet {

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
		out.print("<head><title>test Servlet</title></head>");
		out.print("<body bgcolor='green'>");
		out.print("<b>Test Servlet1 입니다.<b><br>");
		out.print("<b>context : " + context + "<b><br>");
		out.print("<b>전체경로 : " + url + "<b><br>");
		out.print("<b>매핑 명 : " + mapping + "<b><br>");
		out.print("<b>URI : " + uri + "<b><br>");
		out.print("</body></html>");
		out.close();
	}

}








