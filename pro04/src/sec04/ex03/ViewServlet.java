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

import sec04.ex03.MemberVO;


@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("ViewServlet Init");
	}
	public void destroy() {
		System.out.println("ViewServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ViewServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ViewServlet doPost");
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ViewServlet Start");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List membersList = (List)request.getAttribute("membersList"); 
		out.print("<html><body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td>");
		out.print("<td>이름</td><td>이메일</td><td>가입일자</td><td>삭제여부</td></tr>");
		
		for(int i=0;i<membersList.size();i++) {
			MemberVO memberVO = (MemberVO)membersList.get(i);
			
			String id = memberVO.getId();
			String pw = memberVO.getPw();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			out.print("<tr><td>" + id + "</td>");
			out.print("<td>" + pw + "</td>");
			out.print("<td>" + name + "</td>");
			out.print("<td>" + email + "</td>");
			out.print("<td>" + joinDate + "</td>");
			out.print("<td><a href='/pro03/member4?command=delMember&id="+id+"'>삭제</a></td></tr>" );
		}
		out.print("</table>");
		out.print("<a href='/pro03/MemberForm.html'>회원등록하기</a>");
		out.print("</body></html>");
		
		System.out.println("ViewServlett End");
	}

}








