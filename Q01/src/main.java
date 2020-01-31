

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("")
public class main extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Main init");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Main doGet");
	}

	@Override
	public void destroy() {
		System.out.println("Main destroy");
	}
}
