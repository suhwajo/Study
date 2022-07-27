package practice_1;

public class OverLoading {

	public static void main(String[] args) {
		System.out.println(add(3,5L));
		System.out.println(add(5L,3));
		
	}
	
	public static long add(long a,int b) {
		System.out.println("Add method1");
		return a+b;
	}
	
	public static long add(int b,long a) {
		System.out.println("Add method2");
		return a+b;
	}
}
