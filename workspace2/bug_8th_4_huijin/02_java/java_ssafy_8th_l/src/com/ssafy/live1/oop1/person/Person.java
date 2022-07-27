package com.ssafy.live1.oop1.person;

public class Person {
	//멤버 변수 - 속성 , 데이터
	
	//클래스 멤버 변수
	static String org = "ssafy";
	
	//인스턴스 멤버 변수
	String name;
	int age;
	boolean isHungry;
	
	//Alt + shift + s
	public Person(String name, int age, boolean isHungry) {
		super();
		this.name = name; //this 가 생김. 
		this.age = age;
		this.isHungry = isHungry;
	}

	//멤버 메서드 - 동작
	void eat() {
		System.out.println("냠냠");
		isHungry = false;
	}
	
	void work() {
		System.out.println("열심히 ...");
		isHungry = true;
	}
}
