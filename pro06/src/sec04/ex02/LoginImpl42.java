package sec04.ex02;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
// HttpSessionBindingListener를 제외한 Listener를 구현한 모든 이벤트 핸들러는 반드시 어노테이션을 이용해서 Listener로 등록해야 한다.

public class LoginImpl42 implements HttpSessionListener{
	String user_id;
	String user_pw;
	static int total_user = 0;
	
	public LoginImpl42(){}
	public LoginImpl42(String user_id, String user_pw){
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("사용자 접속----------------------");
		++this.total_user;
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("사용자 접속 해제---------------------");
		--this.total_user;
	}
	
	
}
