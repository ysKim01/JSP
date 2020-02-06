package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login51")
public class LoginServlet51 extends HttpServlet {
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
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPw(user_pw);

		MemberDAO dao = new MemberDAO();
		
		boolean result = dao.isExisted(memberVO);
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pw", user_pw);
			
			out.print("<html><body>");
			out.print("안녕하세요  " + user_id + "님!!<br>");
			out.print("<a href='show'>회원정보보기</a>");
			out.print("</body></html>");
		}else {
			out.print("<html><body>");
			out.print("회원 정보가 틀렸습니다.<br>");
			out.print("<a href='login3.html'>로그인 창</a>");
			out.print("</body></html>");
		}
		
		
		System.out.println("LoginServlet doHandle End");
	}
}
