package sec06.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "loadconfig", urlPatterns = { "/loadconfig" }, loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
	private ServletContext context;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadAppConfig Init");
		context = config.getServletContext();
		
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		context.setAttribute("menu_member", menu_member);
		context.setAttribute("menu_order", menu_order);
		context.setAttribute("menu_goods", menu_goods);
	}
	public void destroy() {
		System.out.println("LoadAppConfig Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoadAppConfig doGet");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoadAppConfig doPost");
		doHandle(request, response);
	}

	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoadAppConfig doHandle Start");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String menu_member = (String)context.getAttribute("menu_member");
		String menu_order = (String)context.getAttribute("menu_order");
		String menu_goods = (String)context.getAttribute("menu_goods");
		
		
		
		out.print("<html><body>");
		out.print("회원메뉴 : " + menu_member + "<br>");
		out.print("주문메뉴 : " + menu_order + "<br>");
		out.print("상품메뉴 : " + menu_goods + "<br>");
		out.print("</body></html>");
		out.close();
		
		System.out.println("LoadAppConfig doHandle End");
	}

}
