package sec03.Quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginQuiz01")
public class QuizServlet01_Login extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init");
	}
	public void destroy() {
		System.out.println("Destroy"); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Execute doPost");
		doHandle(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Execute doGet");
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Execute doHandle");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		// 아이디 비밀번호 미 입력 시
		String data = "<html><body>";
		if(id==null || id.equals("")) {
			data += "아이디를 입력해 주세요<br>";
		}else if(pw==null || pw.equals("")) {
			data += "비밀번호를 입력해 주세요<br>";
		}else {
			if(id.equals("admin") && pw.equals("admin")) {
				data += "<button>회원삭제</button><br>";
				data += "<button>회원수정</button><br>";
			}else {
				data += id + "님 환영합니다!!<br>";
			}
		}
		data += "<a href='/pro02/login.html'>로그인 화면</a>";
		data += "</body></html>";
		
		PrintWriter out = response.getWriter();
		out.print(data);
		out.close();
	}
	
}
