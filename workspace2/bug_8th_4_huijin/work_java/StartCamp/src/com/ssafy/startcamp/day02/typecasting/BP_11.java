package com.ssafy.startcamp.day02.typecasting;

public class BP_11 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
        
        // @@TODOINLINE: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
        int b3 = b1 + b2; //b1+b2 는 int 형. byte -> int

        int i1 = 10;
        long l1 = 20;
        // @@TODOINLINE: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
        int i2 = (int) (i1 + l1); // + 할 때, 큰 타입을 따라감. long 을 int로 넣을 순 없음. type 변환을 해줘야 한다.
        
        // @@TODOINLINE: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
        float f1 = 10.0f; // 10.0 -> double 형. 기본적으로 실수형은 자바에서 double로 인식하게 됨.
        //float으로 쓸려면 뒤에 f 써주기
        
        float f2 = (float) (f1 + 20.0); // type casting 
    }

}