import java.util.*;

class MenuOfRestro{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		boolean flag = false;
		int finalPrice = 0;
		int dosaPrice = 20;
		int samosaPrice = 20;
		int idli = 30;
		int wadaPav = 15;
		int chai = 10;
		int litti = 100;

		while(!flag) {
			System.out.println("Press 1 for Dosa");
			System.out.println("Press 2 for Samosa");
			System.out.println("Press 3 for Idli");
			System.out.println("Press 4 for WadaPav");
			System.out.println("Press 5 for Chai");
			System.out.println("Press 6 for LittiChokha");
			System.out.println("Press 10 for generating bill");
			
			int option = sc.nextInt();
			switch(option) {
				
				case 1:
					finalPrice += dosaPrice;
					break;
				case 2:
					finalPrice += samosaPrice;
					break;
				case 3:
					finalPrice += idli;
					break;
				case 4:
					finalPrice += wadaPav;
					break;
				case 5:
					finalPrice += chai;
					break;
				case 6:
					finalPrice += litti;
					break;
				case 10:
					System.out.println("Total bill is: " + finalPrice);
				default:
					flag = true;
			}
			
		}
		
		sc.close();
		
	}	
}