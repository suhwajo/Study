package com.ssafy.live1.oop1.constructor;

public class OverloadConstructorPerson {
	String name = "아무개";
	int age = 0;
	
	
	public OverloadConstructorPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public OverloadConstructorPerson(String name) {
		this(name , 0);
	}
	
	public OverloadConstructorPerson() {
		//첫번째 라인에서만 사용 가능
		this("홍길동",100);
	}
	
}
