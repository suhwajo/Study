package com.ssafy.live3.inter.relation;


// TODO: DigitalCamera를 충전 가능하게 설정하시오.
public class DigitalCamera extends Camera implements Chargeable{

	@Override
	public void charge() {
		System.out.println("디지털카메라 충전!");
	} 
    // TODO: Chargeable을 구현하시오.
    // END:
}
