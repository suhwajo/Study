package com.ssafy.live4.collection.sort;

public class SmartPhone2 implements Comparable<SmartPhone>{
	private String number;
	
	public SmartPhone2(String number) {
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
