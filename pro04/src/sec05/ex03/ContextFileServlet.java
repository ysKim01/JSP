package sec05.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {
	public void init() throws ServletException {
		System.out.println("ContextFileServlet Init");
	}
	public void destroy() {
		System.out.println("ContextFileServlet Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ContextFileServlet doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ContextFileServlet doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ContextFileServlet doHandle Start");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		String menu = null;
		String menu_member = null;
		String menu_order = null;
		String menu_goods = null;
		while((menu=buffer.readLine()) != null) { // 한 줄씩 처리
			StringTokenizer tokens = new StringTokenizer(menu, ",");
			menu_member = tokens.nextToken();
			menu_order = tokens.nextToken();
			menu_goods = tokens.nextToken();
		}
		
		out.print("<html><body>");
		out.print("<table border=1 cellspacing=0>");
		out.print("<tr>메뉴 이름</tr>");
		out.print("<tr><td>" + menu_member + "</td></tr>");
		out.print("<tr><td>" + menu_order + "</td></tr>");
		out.print("<tr><td>" + menu_goods + "</td></tr>");
		out.print("</table>");
		out.print("</body></html>");
		out.close();
		
		System.out.println("ContextFileServlet doHandle End");
	}

}
