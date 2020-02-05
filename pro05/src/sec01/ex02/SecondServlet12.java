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
			out.print("�̹� �α��� ���� �Դϴ�.<br><br>");
			out.print("ù��° �������� �Ѱ��� ���̵� : " + id + "<br>");
			out.print("ù��° �������� �Ѱ��� �н����� : " + pw + "<br>");
			out.print("ù��° �������� �Ѱ��� �ּ� : " + address + "<br>");
		}else {
			out.print("�α����ϼ���!<br><br>");
			out.print("�α��� �������� �̵��ϼ���.<br>");
			out.print("<a href='/pro05/login.html'>�α���������</a>");
		}
		out.print("</body></html>");
		out.close();
		System.out.println("SecondServlet doHandle End");
	}

}
