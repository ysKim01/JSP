package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64.Decoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second12")
public class SecondServlet12 extends HttpServlet {
	public void init() throws ServletException {
		System.out.println("SecondServlet Init");
	}
	public void destroy() {
		System.out.println("SecondServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SecondServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SecondServlet doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SecondServlet doHandle Start");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		
		out.print("<html><body>");
		if(id != null && id.length()!=0) {
			out.print("이미 로그인 상태 입니다.<br><br>");
			out.print("첫번째 서블릿에서 넘겨준 아이디 : " + id + "<br>");
			out.print("첫번째 서블릿에서 넘겨준 패스워드 : " + pw + "<br>");
			out.print("첫번째 서블릿에서 넘겨준 주소 : " + address + "<br>");
		}else {
			out.print("로그인하세요!<br><br>");
			out.print("로그인 페이지로 이동하세요.<br>");
			out.print("<a href='/pro05/login.html'>로그인페이지</a>");
		}
		out.print("</body></html>");
		out.close();
		System.out.println("SecondServlet doHandle End");
	}

}
