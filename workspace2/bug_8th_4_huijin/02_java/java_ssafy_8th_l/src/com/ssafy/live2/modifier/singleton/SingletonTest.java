package com.ssafy.live2.modifier.singleton;

class SingletonClass{
    // TODO:SingletonClass에 Singleton Design Pattern을 적용하시오.
    // stateless 한 클래스 - 상태를 가지지 않고 기능만 가짐
	
	//내부적으로 객체 생성
	private static SingletonClass sc = new SingletonClass();
	
	//생성자의 접근제한자를 private로
	private SingletonClass() {}
	
	//객체 반환. getter. 객체를 생성하지 않아도 return 할 수 있게 static 설정.
	public static SingletonClass getSingleTonClass() {
		return sc;
	}
	
	// END:
    public void sayHello() {
      System.out.println("Hello");
    }
    
  }

  public class SingletonTest {
    public static void main(String[] args) {
    	// TODO:SingletonClass를 사용해보세요.  
    	
    	//singleton에 클래스의 getter를 통해 접근
    	SingletonClass sc = SingletonClass.getSingleTonClass(); 
    	sc.sayHello();
    	
    	SingletonClass sc2 = SingletonClass.getSingleTonClass(); 
    	sc2.sayHello();
    	
    	System.out.println(sc==sc2);
    	
    	// END:
    }
  }
