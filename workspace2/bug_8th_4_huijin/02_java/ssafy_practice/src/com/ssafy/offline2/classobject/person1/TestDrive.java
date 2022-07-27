package com.ssafy.offline2.classobject.person1;

public class TestDrive {

	public static void main(String[] args) {
		int a = 10;
		Person yang = new Person();
		yang.name = "양희진";
		yang.age = 25;
		yang.gender = "여성";
		yang.job = "학생";
		yang.address = "부산 강서구 명지동";
		
		yang.walk();
		yang.run();
		yang.eat();
		System.out.println(yang.age+" / "+yang.gender+" / "+yang.address);
		
		Person kim = new Person();
		kim.name ="김보경";
		kim.age=26;
		kim.gender="남성";
		kim.job="교육생";
		kim.address="하단";
		
		kim.walk();
		kim.run();
		kim.eat();
	}
}
