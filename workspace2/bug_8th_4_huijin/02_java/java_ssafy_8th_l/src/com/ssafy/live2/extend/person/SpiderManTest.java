package com.ssafy.live2.extend.person;

public class SpiderManTest {
	
	//static 은 객체를 만들지 않고도 호출 가능. static 이 아니면 객체로 만들어서 호출해야 함
	public static void main(String[] args) {
		SpiderMan sman = new SpiderMan("피터파커",false);
		sman.isSpider = true;
		sman.eat(); //person
		sman.jump(); //spiderman
		sman.fireWeb(); //spiderman
		System.out.println(sman.toString());
	}

}
