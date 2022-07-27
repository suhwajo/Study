package com.ssafy.live4.collection.sort;

//정렬하기 위해 Comparable 인터페이스 상속받기. 제네릭에 비교하려는 객체 타입을 넣어줄 것
public class SmartPhone implements Comparable<SmartPhone>{

	private String number;
	
	public SmartPhone(String number) {
		this.number = number;
	}

	@Override
	public int compareTo(SmartPhone o) {
		
		//String 클래스의 compareTo 메소드를 재사용
		//폰 번호 기준으로 오름차순 정렬이 됨
		return this.number.compareTo(o.number);
	}
	
	@Override
	public String toString() {
		return "전화번호: " +number;
	
	}

}
