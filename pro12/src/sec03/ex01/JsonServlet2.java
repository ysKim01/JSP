package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject totalObject = new JSONObject();

		JSONObject memberInfo = new JSONObject();
		JSONArray membersArray = new JSONArray();
		
		// 객체 입력
		memberInfo.put("name","박지성");
		memberInfo.put("age","25");
		memberInfo.put("gender","남");
		memberInfo.put("nickname","두개의 심장");
		// 배열에 객체 추가
		membersArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		// 객체 입력
		memberInfo.put("name","김연아");
		memberInfo.put("age","22");
		memberInfo.put("gender","여");
		memberInfo.put("nickname","피겨여왕");
		// 배열에 객체 추가
		membersArray.add(memberInfo);
		
		
		totalObject.put("members", membersArray);
		
		String jsonInfo = totalObject.toJSONString();
		System.out.println(jsonInfo);
		writer.print(jsonInfo);
	}
}









