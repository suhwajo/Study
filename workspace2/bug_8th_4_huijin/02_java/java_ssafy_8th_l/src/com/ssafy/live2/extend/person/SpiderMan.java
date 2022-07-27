package com.ssafy.live2.extend.person;

public class SpiderMan extends Person {
	boolean isSpider;
	Spider spider = new Spider() ;//객체를 생성해주어야 한다.
	
	public SpiderMan(String name,boolean isSpider){
		//this() 또는 super() 가 올 수 있는데 아무것도 없으면 누가 생략?? => super가 생략
		//super(); //부모 클래스에는 기본생성자가 사라짐. 따라서 오류가 뜬다. 
		super(name);
		this.isSpider= isSpider;
	}
	
	public void fireWeb() {
		if(isSpider) {
			//null pointer => null.XX
			//null -> 메모리에 올라간 것만 쓸 수 있다.
			//static 이 아닌것은 new 로 객체를 생성해서 쓸 수 있다.
			spider.fireWeb();
		}
		
		else System.out.println("사람일때는 참자! ");
	}
	
	//메서드 오버라이딩
	public void jump() {
		if(isSpider) {
			spider.jump();
		}
		else {
			System.out.println("두 다리로 폴짝!!");
		}
	}

	@Override
	public String toString() {
		//return "SpiderMan [isSpider=" + isSpider + ", spider=" + spider + "]";
		return super.toString() +", isSpider : "+isSpider;
		//super.toString() 으로 조상(부모) 클래스의 메서드를 실행 가능
	}
	
	
}
