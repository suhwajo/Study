package com.ssafy.offline2.classobject.person2;

public class TestDrive {

	public static void main(String[] args) {
		int a = 10;
		Person yang = new Person("양희진",25,"학생", "부산 강서구 명지동" ,"여성");

		
		yang.walk();
		yang.run();
		yang.eat();
		yang.introduce();
		
		System.out.println(yang);
		Person kim = new Person("김보경" ,26,"교육생", "하단","남성");

		
		kim.walk();
		kim.run();
		kim.eat();
		kim.introduce();
		System.out.println(kim);
	}
}
