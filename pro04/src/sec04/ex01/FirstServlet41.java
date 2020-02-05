package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first41")
public class FirstServlet41 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet Init");
	}
	public void destroy() {
		System.out.println("FirstServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet Handle Start");
		response.setContentType("text/html;charset=utf-8");
		
		request.setAttribute("address", "���� ���α�");
		 response.sendRedirect("second41"); //-> �ƹ��͵� �ȳѾ��.
		// redirect�� Ŭ���̾�Ʈ�� �� ��û�� �ϱ⿡ �Ӽ����� Ŭ���̾�Ʈ�� ���� ���� �������ΰ���.
		// �Ӽ����� Ŭ���̾�Ʈ�� ���޵� �������� �Ӽ����� �����ֱ⸦���ع����� ���ż������� ���⶧����
		// ���ż������μ� �ƹ��͵� ���� ���ϴ� ��.
		
		System.out.println("FirstServlet Handle End");
	}
}
