package com.webpgy.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
//기본 생성자를 protected하도록 생성(why? 프로그래머가 임의로 기본 생성자를 호출 하지 못하도록)
//프로텍티드한 기본 생성자만 만들어짐 productvo를 상속받은애만 즉 스프링만 호출할 수 있다 리프렉션!
@AllArgsConstructor //이건 아래 생성 값을 다 줘야 하는데 어떤건 주고 안주고 하고 싶은데!! 그럴때 아래 빌더 사용
@Builder
@ToString
@Getter
@Setter

public class ProductVO {

	private String productNo;
	private String productName;
	private int qty;
	private int price;
	private String productNickName;
//기본 생성자 겟터 세터 jsp가 지가 만들어서 호출할때 사용했었다
//기본 생성자는 스프링 컨트롤러단 객체가 이용해서 호출한다.
//그러나 우리는 가급적 기본 생성자를 사용하지 않게!
}
