package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetAttribute extends HttpServlet {

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
		
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		// 다 됨 - 톰캣에 있기 때문
		String ctxMsg = (String)ctx.getAttribute("context");	 
		// 처음 브라우저 만 됨, 다른 브라우저(클라이언트) 일 경우 안됨
		String sesMsg = (String)session.getAttribute("session");
		// 따로 전달받지 않았기 때문에 없음
		String reqMsg = (String)request.getAttribute("request"); 
		
		out.print("context 값 : " + ctxMsg + "<br>");
		out.print("session 값 : " + sesMsg + "<br>");
		out.print("request 값 : " + reqMsg + "<br>");
	}

}








