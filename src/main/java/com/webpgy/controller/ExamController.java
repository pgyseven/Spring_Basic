package com.webpgy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webpgy.model.ProductVO;

@Controller
@RequestMapping("/exam") // "/exam" uri로 호출되면 현재의 컨트롤러가 동작하도록
public class ExamController {
	
	@RequestMapping("/outputProduct")
	public void outputProduct(Model model) {
		System.out.println("outputProduct()...................");
		ProductVO exproduct = new ProductVO("240704_1","새우깡" , 5, 2000, "손이가요 손이가~");
				System.out.println(exproduct.toString());
		model.addAttribute("product",exproduct);
		
		// /WEB-INF/views/exam/outputProduct.jsp 를 반환
		
	}

	@RequestMapping("inputProduct") // /exam/inputProduct가 get 방식으로 호출 되었을때
	public void inputProduct() {
		// 아래의 view 페이지(제품입력페이지) 출력
		// /WEB-INF/views/exam/inputProduct.jsp
		
		
	}
	
	//requestParam을 이요한 매개변수 수집 방법
	/*
	 * @RequestMapping(value = "/inputProduct", method = RequestMethod.POST) public
	 * void saveProduct(@RequestParam("productNo") String productoNo,
	 * 
	 * @RequestParam("productName") String productName,
	 * 
	 * @RequestParam("qty") int qty,
	 * 
	 * @RequestParam("price") int price,
	 * 
	 * @RequestParam("productNickName") String productNickName) {
	 * //@RequestParam("productNo") 여기서 받아와서 String productoNo여기 지역변수에 저장 되는 것 /
	 * request.getparam 과 같게 작동한다. RequestParam // /exam/inputProduct 가 POST방식으로 호출될
	 * 때 현재 메서드가 매핑되도록 System.out.println("saveProduct()..............!");
	 * 
	 * ProductVO p = new ProductVO(productoNo, productName, qty, price,
	 * productName); System.out.println(p.toString());
	 * 
	 * }
	 */
	
	
	// 파라메터를 Spring ftamwork가 자동 수집하여, 객체로 만들어준다.
	@RequestMapping(value = "/inputProduct", method = RequestMethod.POST) 
	public String saveProduct(ProductVO p, RedirectAttributes redirectAttributes) { //메소드의 매개 변수 자리! 이렇게 하면 기본 생성자를 호출해서 빈객체를 만들고 세터를 호출해서 넣어준다. / 객체로 만들고 싶을때는 이렇게 쓰고 아닐때는 위와 같이 쓴다. / 매개변수를 자동으로 수집해줌
	//RedirectAttributes 리다이렉트할때 가지고 갈수 있는 속성
		System.out.println("saveProduct()..............!");
	
	// ProductVO p = new ProductVO(productoNo, productName, qty, price, productName);
	System.out.println(p.toString());
	
	// p를 서비스단 -> dao 단 -> DB에 잘 저장했다 치자~~
	String msg = null;
	if(p != null) {
		msg = "success";
		
	}
	//redirectAttributes.addAttribute("status",msg); //?status 쿼리 스트링 물음표 다음에 나오는게 쿼리 스트링 이렇게 하면 http://localhost:8081/controller/?status=success 리다이렉트에서 home의 주소에 이렇게 붙어있게 된다.
	//status 라는 변수의 값이 msg 로..(쿼리 스트링으로 추가됨)
	
	redirectAttributes.addFlashAttribute("status",msg); //변조하지 않게 하기 위해서! 즉 보안적으로 우수하게 하기 위해서 이렇게 하면 눈으로는 안보임 즉 그냥 바인딩만 된거임 <div>${status }</div> 해서 home에 넣으면 페이지에 success 라고만 뜸
	//status 라는 변수의 값이 msg로...(쿼리 스트링으로 추가 되지 않고 그냥 바인딩) 
	
	return "redirect:/"; //다른 컨트롤러 단으로 이동 가능하다 분리하라고 이렇게 한 것이다. 회원관리, 게시판 이런식으로 해당 기능의 컨트롤러가 있을거니깐 컨트롤러가 여러개 일 수 있고 호출이 가능하다.
	
	
	
	}
	
	
}
