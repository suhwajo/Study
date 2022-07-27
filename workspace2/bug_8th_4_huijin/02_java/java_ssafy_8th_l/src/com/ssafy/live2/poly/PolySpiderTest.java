package com.ssafy.live2.poly;

import com.ssafy.live2.extend.person.Person;
import com.ssafy.live2.extend.person.SpiderMan;

public class PolySpiderTest {

	public static void main(String[] args) {
		//spiderman -> 생성자 package라서 안됐음. public 으로 생성자 전환
		SpiderMan sman = new SpiderMan("피터파커",false);
		
		//다형성
		SpiderMan sman2 = sman;
		
		Person person = sman; //레퍼런스 가능. 조상 클래스 타입으로 자식 클래스 객체를 레퍼런스
		Object obj = person; //조상의 것을 자식이 모두 가지고 있기 때문에 걱정할 필요 없음.
		
		//obj.eat(); <- 오류
		
		//형 변환
		SpiderMan reSpider = (SpiderMan)obj; //조상 -> 자식. 거미줄쓰는 기능이 조상에겐 없을 수 있다. 값 손실 우려. -> 명시적 케스팅
		
		//뭐든지 담을 수 있는 만능의 주머니.
		Object[] objs = new Object[4];
		objs[0] = sman;
		
		objs[1] = "Hello";
		
		objs[2]= objs; //객체 배열도 담을 수 있다! 주소를 가리키게 하는 거니까 넣을 수 있음.
		
		SpiderMan fromObjArray = (SpiderMan)objs[0];
		fromObjArray.fireWeb(); //objs[0] 은 spiderman이므로 오류 없음.
		
		//형변환을 할때에는 반드시 타입을 확인하고 하자!
		if(objs[1] instanceof SpiderMan) {
			SpiderMan fromObjArray2 = (SpiderMan)objs[1];
			fromObjArray2.fireWeb();
		}
		
		
		objs[3] = 1; //기본형인데 담긴다...??! 자동으로 Wrapping이 됨.(형변환) -> Integer로 담긴다.
		
		for(Object o:objs) {
			System.out.println(o.getClass().getName());
		}
		
	}

}
