package com.ssafy.live2.extend.person;

public class Person {
	String name="피터파커";
	
	//생성자
	Person(String name){
		this.name = name;
	}
	
	void eat() {
		System.out.println("냠냠.");
	}
	void jump() {
		System.out.println("두다리로 폴짝!");
	}
}
