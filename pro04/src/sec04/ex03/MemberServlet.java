package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member43")
public class MemberServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("MemberServlet Init");
	}
	public void destroy() {
		System.out.println("MemberServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberServlet doPost");
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberServlet Start");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		
		List membersList = dao.listMembers();
		request.setAttribute("membersList", membersList);
		RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
		dispatch.forward(request, response);
		
		System.out.println("MemberServlet End");
	}

}








