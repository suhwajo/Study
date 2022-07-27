package com.ssafy.offline2.classobject.person2;

public class Person {
	
	//필드 (멤버변수) : 속성
	String name;
	int age;
	String job;
	String address;
	String gender;
	
	//기본 생성자(다른 생성자가 존재하지 않으면, 컴파일러가 자동으로 생성)
	//다른 생성자가 존재하면 기본생성자는 생성이 안됩니다.
	public Person() {
		
	}
	
	public Person(String name,int age, String job, String address,String gender) {
		this.name = name;
		this.age = age;
		this.job = job;
		this.address = address;
		this.gender = gender;
		System.out.println(this.name+" 이(가) 탄생!");
	}
	
	//메서드(멤버함수) : 행동
	void walk() {
		System.out.println(name+" 이(가) 걷는다.");
	}
	
	void run() {
		System.out.println(name+" 이(가) 달린다.");
	}
	
	void eat() {
		System.out.println(name+" 이(가) 먹는다.");
	}
	
	void introduce() {
		System.out.println("이름 : "+this.name+" 나이: "+this.age+" 주소: "+this.address);
	}
	
	
	//Alt shift S 누르면 toString generate 자동으로 가능
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=").append(name).append(", age=").append(age).append(", job=").append(job)
				.append(", address=").append(address).append(", gender=").append(gender).append("]");
		return builder.toString();
	}
	
	/*
	@Override
	public String toString() { //string으로 반환.
		//java 8버전 이후에는 이렇게 사용해도 ok
		//return "이름 : "+this.name+" 나이: "+this.age+" 주소: "+this.address;
		
		//java 8보다 낮다면 아래처럼 stringbuilder 사용
		StringBuilder sb = new StringBuilder();
		//heap 영역에 저장됨. 계속 뒤로 이어붙이면서 할당된다.
		sb.append("이름 :")
		.append(this.name)
		.append("나이 :")
		.append(this.age)
		.append("주소 :")
		.append(this.address);
		
		return sb.toString();
	}*/
}
