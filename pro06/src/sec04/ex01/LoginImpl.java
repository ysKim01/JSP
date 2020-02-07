package sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener{
	String user_id;
	String user_pw;
	static int total_user = 0;
	
	public LoginImpl(){}
	public LoginImpl(String user_id, String user_pw){
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// 세션에 값이 추가될 때
		System.out.println("사용자 접속----------------------");
		++this.total_user;
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// 세션에 값이 삭제될 때
		System.out.println("사용자 접속 해제---------------------");
		--this.total_user;
	}
	
	
}
