package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login12")
public class LoginServlet12 extends HttpServlet{
	public void init() throws ServletException {
		System.out.println("LoginServlet Init");
	}
	public void destroy() {
		System.out.println("LoginServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doHandle Start");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		String email = request.getParameter("user_email");
		String hp = request.getParameter("user_hp");
		
		out.print("<html><body>");
		out.print("아이디 : " + id + "<br>");
		out.print("패스워드 : " + pw + "<br>");
		out.print("주소 : " + address + "<br>");
		out.print("이메일 : " + email + "<br>");
		out.print("전화번호 : " + hp + "<br>");
		
		// get 방식으로 한글을 전송하기 위한 암호화 - get방식은 한글을 인식못함
		address = URLEncoder.encode(address, "utf-8");
		out.print("<a href='/pro05/second12?"
				+ "user_id" + id
				+ "&user_pw" + pw
				+ "&user_address" + address
				+ "'>전송</a>"
				);
		
		out.print("</body></html>");
		out.close();
		System.out.println("LoginServlet doHandle End");
	}
}
