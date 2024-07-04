package com.webpgy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value = "/inputProduct", method = RequestMethod.POST) 
	public void saveProduct(ProductVO p) { //메소드의 매개 변수 자리! 이렇게 하면 기본 생성자를 호출해서 빈객체를 만들고 세터를 호출해서 넣어준다. / 객체로 만들고 싶을때는 이렇게 쓰고 아닐때는 위와 같이 쓴다. / 매개변수를 자동으로 수집해줌
	System.out.println("saveProduct()..............!");
	
	// ProductVO p = new ProductVO(productoNo, productName, qty, price, productName);
	System.out.println(p.toString());
	
	}
	
	
}
