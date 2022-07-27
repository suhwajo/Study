package com.ssafy.live3.inter;

public class IronMan implements Heroable{
	int weaponDamage = 100;
	
	@Override
	public int fire() {
		System.out.println("적의 에너지 감소 : "+weaponDamage);
		return 0;
	}

	@Override
	public void changeShape(boolean isHeroMode) {
		if(isHeroMode) {
			System.out.println("장갑 장착");
		}
		else {
			System.out.println("일반 토니스타크");
		}
	}

	@Override
	public void upgrade() { //public 지우면 에러. 인터페이스에서는 public이 생략되어있음.
		//상속받는 메서드의 범위는 같거나 더 넓어져야 한다. 
		System.out.println("무기 성능 개선");
	}

}
