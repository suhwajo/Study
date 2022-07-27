package com.ssafy.live4.collection.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortTest {
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Hi","Java","World","Welcome");
		System.out.println(names);
		Collections.sort(names); //String - 알파벳 순으로 정렬해준다. compareTo 메소드 참조
		System.out.println(names);
	
	
		List<SmartPhone> phones = new ArrayList<>();
		phones.add(new SmartPhone("010-3234-5678"));
		phones.add(new SmartPhone("010-2234-5678"));
		phones.add(new SmartPhone("010-1234-5678"));
		
		Collections.sort(phones); // Collections.sort -> SmartPhone 이 Comparable 을 상속받아야 사용 가능
		System.out.println(phones);
		Collections.reverse(phones);
		System.out.println(phones);
		
		
		//익명클래스로 객체 생성
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return Integer.compare(o1.length(), o2.length());
			}
			
		}); //길이순 정렬
		System.out.println(names);
		
		//람다식. (Java 8 제공)
		Collections.sort(names, (o1, o2) -> Integer.compare(o1.length(),o2.length()));
		
		//
		Calculator c = new Calculator() {

			@Override
			public Integer calc(Integer a, Integer b) {
				return a-b;
			}
			
		};
		Calculator c2 = new Calculator() {

			@Override
			public Integer calc(Integer a, Integer b) {
				return a*b + 1;
			}
			
		};
		
		run(c);
		run(c2);
		
		run((a,b) => a = a+a+b);
		
		Integer result = c.calc(100, 50);
		System.out.println(result);
	}
	
	public static void run(Calculator c) {
		System.out.println("계산하는 중 입니다...");
		Integer result = c.calc(200, 55);
		System.out.println("계산한 결과는 "+result+" 입니다.");
	}
}
