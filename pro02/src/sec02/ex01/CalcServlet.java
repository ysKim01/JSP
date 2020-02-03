package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init");
	}
	public void destroy() {
		System.out.println("Destroy");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		String command = request.getParameter("command");	// 수행할 요청
		String won = request.getParameter("won");			// 변환할 원화
		String operator = request.getParameter("operator");	// 변환할 외화 종류
		
		// 환율 계산 되었을 때 
		if(command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><font size=10>변환결과</font><br>");
			pw.print("<font size=10>" + result + "</font><br>");
			pw.print("<a href='/pro02/calc'>환율계산기</a></html>");
			return;
		}
		
		// 환율 계산을 하기 위한 페이지
		pw.print("<html><title>환율계산기</title>");
		pw.print("<body><font size=5>환율계산기</font><br>");
		pw.print("<form name='frmCalc' method='get' action='/pro02/calc'>");
		pw.print("원화 : <input type='text' name='won' size=10 />");
		pw.print("<select name='operator' >");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='wian'>위안</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate' />");
		pw.print("<input type='submit' value='변환' />");
		pw.print("</form>");
		pw.print("</body>");
		pw.print("</html>");
		pw.close();
		
	}

	private static String calculate(float won, String operator) {
		String result = null;
		
		float USD_RATE = 0.00084f;
		float JPT_RATE = 0.091f;
		float CNY_RATE = 0.0059f;
		float GBP_RATE = 0.013f;
		float EUR_RATE = 0.00076f;
		
		if(operator.equals("dollar")) {
			result = String.format("%.6f", won*USD_RATE);
		}else if(operator.equals("en")) {
			result = String.format("%.6f", won*JPT_RATE);
		}else if(operator.equals("wian")) {
			result = String.format("%.6f", won*CNY_RATE);
		}else if(operator.equals("pound")) {
			result = String.format("%.6f", won*GBP_RATE);
		}else if(operator.equals("euro")) {
			result = String.format("%.6f", won*EUR_RATE);
		}
		
		return result;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
