package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first42")
public class FirstServlet42 extends HttpServlet {
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
		
		request.setAttribute("address", "서울 종로구");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("second42");
		dispatch.forward(request, response);
		// 중요!!
		// SecondServlet이 실행 종료 된 후  FirstServlet이 마저 종료됨.
		// url도 first42로 되어있다.
		// 함수를 불러내는 개념
		
		System.out.println("FirstServlet Handle End");
	}
}
