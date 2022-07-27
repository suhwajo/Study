package com.ssafy.live1.oop1.constructor;

public class ParameterPerson {
	
	//멤버 변수, 필드
	String name;
	int age;
	boolean isHungry;
	
	
	//생성자의 역할 : member 변수의 초기화 ..
	//alt shift S : 생성자 만들기
	public ParameterPerson(String name, int age, boolean isHungry) {
		super();
		this.name = name;
		this.age = age;
		this.isHungry = isHungry;
	}
	
	
	
	// main -> ctrl enter. 메인 메서드 생성
	public static void main(String[] args) {
		ParameterPerson person = new ParameterPerson("홍길동", 10,true);
		//ParameterPerson p2 = new ParameterPerson(); //에러 발생. 생성자가 생겨서 기본 생성자가 사라짐.
		
	}
}
