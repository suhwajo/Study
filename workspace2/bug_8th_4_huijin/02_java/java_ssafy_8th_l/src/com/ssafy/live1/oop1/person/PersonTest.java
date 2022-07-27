package com.ssafy.live1.oop1.person;

//Person을 사용하는 주체?
public class PersonTest {

	public static void main(String[] args) {
		//붕어빵틀 -> 붕어빵
		Person p = new Person(); //Person 즉 클래스 이름은 타입!
		
		p.name = "홍길동";
		p.age = 30;
		p.isHungry = true;
		p.eat();
		System.out.println(p.name+" : "+p.isHungry+" : "+Person.org);
		
		Person p2 = new Person();
		p2.name ="장길산";
		System.out.println(p2.name+" : "+p2.isHungry);
	}

}
