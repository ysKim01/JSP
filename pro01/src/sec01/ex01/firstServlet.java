package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class firstServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("First init �޼��� ȣ��");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("First doGet �޼��� ȣ��");
	}

	@Override
	public void destroy() {
		System.out.println("First destroy �޼��� ȣ��");
	}
	
}
