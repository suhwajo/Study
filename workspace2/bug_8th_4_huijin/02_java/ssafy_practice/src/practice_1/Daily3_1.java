package practice_1;

public class Daily3_1 {

	public static void main(String[] args) {
		int a=5;
		int chk=a;
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=15;i++) {
			
			System.out.print(i+"  ");
			
			
			chk--;
			if(chk==0) {
				a-=1;
				chk=a;
				System.out.println();
				
				for(int j=0;j<5-a;j++) {
					System.out.print("   ");
				}
			}
			
			
		}
		
		
		
	}

}
