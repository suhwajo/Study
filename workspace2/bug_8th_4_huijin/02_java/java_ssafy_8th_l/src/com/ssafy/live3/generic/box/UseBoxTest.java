package com.ssafy.live3.generic.box;

public class UseBoxTest {

    public static void main(String[] args) {
        useNormalBox();
        useGenericBox();
        useNumberBox();
    }

    private static void useNormalBox() {
        // TODO: NormalBox 타입의 객체를 생성하고 사용해보세요.
    	NormalBox nbox = new NormalBox();
    	// Object 처리 --> 뭐든지 담을 수 있다.
    	nbox.setSome(1); //object이므로 어떤 걸 넣어도 괜찮음
    	nbox.setSome("Hello");
    	
    	Object obj = nbox.getSome();
    	
    	//Integer num = (Integer)obj; //컴파일은 되도, 런타임 시 에러가 발생. 
    	//ClassCastException
    	
    	if(obj instanceof String) {
    		//뺄때는 무엇인지 알 수 없기 때문에 타입 체크 필요.
    		String str = (String)obj;
    		System.out.println(str+" : "+str.length());
    	}
    	
        // END:
    }

    private static void useGenericBox() {
        // TODO: GenericBox 타입의 객체를 생성하고 사용해보세요.
    	GenericBox<String> sbox = new GenericBox<>(); //String 타입으로 변환!
    	sbox.setSome("Hello"); //String 객체만 받을 수 있다.
    	//sbox.setSome(1); //컴파일 시점에서 에러. 빨간줄 뜸. -> 쉽게 에러 고칠 수 있다~
    	
    	String s =sbox.getSome(); //리턴 타입이 String!
    	System.out.println(s);
    	
    	GenericBox<Object> obox = new GenericBox<>(); 
    	//Object 타입을 넣으므로써 다양한 타입들을 넣을 수 있다!
    	
        // END:
    }

    private static void useNumberBox() {
        // TODO: NumberBox 타입의 객체를 생성하고 사용해보세요.
        NumberBox<Number> numbox = new NumberBox<>();
        numbox.addSome(1,10L,3.14); //number 타입이 아닌 것은 넣을 수 없다!
    	
        NumberBox<Integer> dbox = new NumberBox<>();
        dbox.addSome(1,3,10); //정수형만 들어올 수 있다. double형 불가능
        
        //NumberBox<String> numbox2 = new NumberBox<>(); //String은 Number 타입이 아니므로 넣지도 못한다!
        // END:
    }

}
