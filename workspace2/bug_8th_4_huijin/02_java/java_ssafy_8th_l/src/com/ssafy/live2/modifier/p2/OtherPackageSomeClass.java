package com.ssafy.live2.modifier.p2;

import com.ssafy.live2.modifier.p1.Parent;

public class OtherPackageSomeClass {
    public void method() {
        // TODO: Parent 객체를 생성하고 이를 통해서 Parent의 멤버에 접근해보세요.
    	Parent p = new Parent(); 
    	p.publicVar=10;
		 p.protectedVar=10;
		 p.defaultVar=10;
		 p.privVar=10;
    	// END:
    }
}
