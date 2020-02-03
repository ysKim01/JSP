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
		
		// ���̵� ��й�ȣ �� �Է� ��
		String data = "<html><body>";
		if(id==null || id.equals("")) {
			data += "���̵� �Է��� �ּ���<br>";
		}else if(pw==null || pw.equals("")) {
			data += "��й�ȣ�� �Է��� �ּ���<br>";
		}else {
			if(id.equals("admin") && pw.equals("admin")) {
				data += "<button>ȸ������</button><br>";
				data += "<button>ȸ������</button><br>";
			}else {
				data += id + "�� ȯ���մϴ�!!<br>";
			}
		}
		data += "<a href='/pro02/login.html'>�α��� ȭ��</a>";
		data += "</body></html>";
		
		PrintWriter out = response.getWriter();
		out.print(data);
		out.close();
	}
	
}
