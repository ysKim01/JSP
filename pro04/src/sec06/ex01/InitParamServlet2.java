package sec06.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml �� ����ϱ�
/*@WebServlet(
		urlPatterns = { 
				"/init", 
				"/init2"
				// �� ���� url�� ����� ���ִ�.
		}, 
		initParams = { 
				@WebInitParam(name = "tel", value = "010-1111-2222"), 
				@WebInitParam(name = "email", value = "admin@kg.com")
		})*/
public class InitParamServlet2 extends HttpServlet {
	public void init() throws ServletException {
		System.out.println("InitParamServlet Init");
	}
	public void destroy() {
		System.out.println("InitParamServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("InitParamServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("InitParamServlet doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("InitParamServlet doHandle Start");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		
		out.print("<html><body>");
		out.print("�̸��� : " + email + "<br>");
		out.print("��ȭ��ȣ : " + tel + "<br>");
		out.print("</body></html>");
		out.close();
		
		System.out.println("InitParamServlet doHandle End");
	}
}
