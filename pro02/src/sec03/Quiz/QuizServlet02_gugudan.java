package sec03.Quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class QuizServlet02_gugudan extends HttpServlet {
	
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
		PrintWriter out = response.getWriter();
		
		String dan = request.getParameter("dan");
		
		// 입력 실패 시
		String data = "<html><body>";
		if(!isNumber(dan)) {
			data += "숫자를 입력하세요!<br>";
			data += "<a href='/pro02/gugudan.html'>입력 화면</a>";
			data += "</body></html>";
			out.print(data);
			out.close();
			System.out.println("입력실패 출력");
			return;
		}
		
		data += "<table border=1 width=800 align=center>";
		data += "<tr align=center bgcolor='#ffff66'>";
		data += "<td colspan=3>"+dan+ "단 출력 </td>";
		data += "</tr>";
		int danNum = Integer.parseInt(dan);
		for(int i=1;i<10;i++) {
			if(i%2==0) {
				data += "<tr align=center bgcolor=#acfa57>";
			}else {
				data += "<tr align=center bgcolor=#ff00ff>";
			}
			data += "<td width=200>";
			data += "<input type='radio'/></td>";
			data += "<td width=400>";
			data += dan + " * " + i;
			data += "</td>";
			data += "<td width=400>";
			data += i*danNum;
			data += "</td>";
			data += "</tr>";
		}
		data += "</table>";
		data += "<br><a href='/pro02/gugudan.html'>입력 화면</a>";
		data += "</body></html>";
		out.print(data);
		out.close();
	}
	private boolean isNumber(String str) {
		boolean result = false;
		try {
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
