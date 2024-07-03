package com.webpgy.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller //아래의 클래스가 컨트롤러 객체임을 명시
public class HomeController { //홈컨트롤클래스는 언제 객체화 되냐? 객체화는 메모리에 올라간다라는 것. 싱글톤이라는 객체를 하나로 돌려쓰는 것 홈컨트롤러가 있으면 가져다 쓰고 모자르면 만들고 이런걸 알아서 해준다. spring bean
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); //로그(개발자가 볼 수 있는 메세지)를 남길 수 있는 객체
	

	@RequestMapping(value = "/", method = RequestMethod.GET) // uri에 "/"가 get 방식으로 요청되면 아래의 메서드가 동작하도록 지정
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		System.out.println("home 메서드가 실행 됨");
		
		//현재 날짜 시간 객체 생성
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date); //날짜 시간을 문자열로 바꾸고
		
		// Model : 뷰단으로 전송할 데이터를 깜쌀 전용 객체 즉 리퀘스트 필요없다 전용 객체가 있으니깐
		model.addAttribute("serverTime", formattedDate ); //Model 객체에 바인딩 view 단으로 전송하기 위해서 여기 forward 같은 것 / 바인딩(객체를 감싸서 전송하는 것) 시켰다.
		
		return "home"; //public String home(Locale locale, Model model) 여기서 스트링이니 문자로 보낼거고 포워딜될 뷰단의 주소가 home 이다.
	}
	
	@RequestMapping("/ex1") // "ex1"이 get 방식으로 요청되면 아래의 메서드가 동작하도록...
	public String examView(Model model) {
		System.out.println("examView 메서드가 동작함 ....");
		model.addAttribute("name","둘리"); //name 이라는 이름으로 "둘리" 바인딩
		return "ex1"; //포워딩될 뷰단의 주소 servlet-context.xml에 의해서 //WEB-INF/views/ex1.jsp
		
	}
	
	@RequestMapping(value="/ex2", method = RequestMethod.GET) // 겟방식이지만 위와 다르게 연습차원에서 다 써봄
	public void exam2View(Model model) {
		System.out.println("exam2View 메서드가 동작함 ....");
		
		//반환값 타입이 void일 경우엔 mapping 된 주소.jsp파일을 찾게 된다. (/WEB-INF/views/하위에서)
		
	}
	
	@RequestMapping ("/ex3")
	public String examRedirect() {
		System.out.println("examRedirect 메서드가 동작함 ....");
		return "redirect:/";  // 다이렉는 페이지 이동이라는 뜻 이런방식은 로그인을 완료하는 경우 다시 그전으로 돌아가야 할때 
	}
	
	
	//ex4를 get 방식으로 요청하면 examView()가 호출되도록 리다이렉트 되는 메서드를 examRedirext2()라는 이름으로 작성해보세요
	@RequestMapping ("/ex4")
	public String examRedirect2() {
		System.out.println("examRedirect2 메서드가 동작함 ....");
		return "redirect:/ex1";  
		//포워딩 데이터를 전달하면서 뷰단 실행 리다이렉트는 재호출
	}



}
