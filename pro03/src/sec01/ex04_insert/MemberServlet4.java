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
			
			// �Է����� ����
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			vo.setEmail(request.getParameter("email"));
			
			dao.addMember(vo); // ���
			
			showList(out, dao); // ����Ʈ ���
			
			System.out.println("addMember End");
		}else if(command.equals("delMember")) {
			System.out.println("delMember Start");
			
			dao.delMember(request.getParameter("id"));
			showList(out,dao);
			
			System.out.println("delMember End");
		}else {
			System.out.println("��ϵ��� ���� Command �Դϴ�.");
		}
		
	}
	private void showList(PrintWriter out, MemberDAO dao) {
		// ����Ʈ ���
		List list = dao.listMembers();
		out.print("<html><body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>���̵�</td><td>��й�ȣ</td>");
		out.print("<td>�̸�</td><td>�̸���</td><td>��������</td><td>��������</td></tr>");
		
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
			out.print("<td><a href='/pro03/member4?command=delMember&id="+id+"'>����</a></td></tr>" );
		}
		out.print("</table>");
		out.print("<a href='/pro03/MemberForm.html'>ȸ������ϱ�</a>");
		out.print("</body></html>");
	}

}








