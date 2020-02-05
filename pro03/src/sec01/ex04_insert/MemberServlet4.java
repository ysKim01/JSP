package sec01.ex04_insert;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member4")
public class MemberServlet4 extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("member4 Init");
	}
	public void destroy() {
		System.out.println("member4 Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet Start");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		if(command==null) {
			System.out.println("command is null");
			System.out.println("Servlet End");
			return;
		}
		
		if(command.equals("addMember")) {
			System.out.println("addMember Start");
			
			// 입력정보 저장
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			vo.setEmail(request.getParameter("email"));
			
			dao.addMember(vo); // 등록
			
			showList(out, dao); // 리스트 출력
			
			System.out.println("addMember End");
		}else if(command.equals("delMember")) {
			System.out.println("delMember Start");
			
			dao.delMember(request.getParameter("id"));
			showList(out,dao);
			
			System.out.println("delMember End");
		}else {
			System.out.println("등록되지 않은 Command 입니다.");
		}
		
	}
	private void showList(PrintWriter out, MemberDAO dao) {
		// 리스트 출력
		List list = dao.listMembers();
		out.print("<html><body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td>");
		out.print("<td>이름</td><td>이메일</td><td>가입일자</td><td>삭제여부</td></tr>");
		
		for(int i=0;i<list.size();i++) {
			MemberVO memberVO = (MemberVO)list.get(i);
			
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
	}

}








