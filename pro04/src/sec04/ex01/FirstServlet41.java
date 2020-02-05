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
		
		request.setAttribute("address", "서울 종로구");
		 response.sendRedirect("second41"); //-> 아무것도 안넘어간다.
		// redirect는 클라이언트에 재 요청을 하기에 속성값이 클라이언트에 갔다 수신 서블렛으로간다.
		// 속성값이 클라이언트에 전달된 시점에서 속성값은 생명주기를다해버리고 수신서블렛으로 가기때문에
		// 수신서블렛으로선 아무것도 받지 못하는 셈.
		
		System.out.println("FirstServlet Handle End");
	}
}
