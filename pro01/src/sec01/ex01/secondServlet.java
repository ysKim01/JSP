package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class secondServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Second init 메서드 호출");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Second doGet 메서드 호출");
	}

	@Override
	public void destroy() {
		System.out.println("Second destroy 메서드 호출");
	}
	
}
