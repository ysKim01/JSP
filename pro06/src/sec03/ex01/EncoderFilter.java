package sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*") // 어노테잇션을 통해 모든 요청이 이 필터를 거친다
public class EncoderFilter implements Filter {
	// 사용자 정의 필터는 반드시 Filter 인터페이스를 구현
	
	ServletContext context;
	
    public EncoderFilter() {
    }
    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("UTF-8 인코딩...");
    	context = fConfig.getServletContext(); // 필터에 접근하는 서블릿의 컨텍스트를 저장
	}
	public void destroy() {
		System.out.println("destroy 호출");
	}

	// 실제 필터 기능
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8");
		
		String context = ((HttpServletRequest)request).getContextPath();
		String pathInfo = ((HttpServletRequest)request).getRequestURI();
		String realPath = request.getRealPath(pathInfo);
		String msg = "Context 정보 : " + context + "\n";
		msg += "URI 정보 : " + pathInfo + "\n";
		msg += "물리적 경로 : " + realPath + "\n";
		System.out.println(msg);
		
		
		long begin = System.currentTimeMillis(); // 요청필터에서 요청처리 전 시간
		// 위로는 요청 필터 기능을 수행
		chain.doFilter(request, response); // 다음 필터로 작업을 넘김
		// 아래로는 응답 필터 기능을 수행
		long end = System.currentTimeMillis(); // 요청필터에서 요청처리 후 시간
		
		System.out.println("작업 시간 : " + (end-begin) + "ms");
		System.out.println("doFilter 종료");
	}


}
