import java.util.*;

class DoubleAssignment {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter 2 Double numbers");

		double d1 = 0, d2 = 0;
		if(sc.hasNextDouble() && sc1.hasNextDouble()) {

			d1 = sc.nextDouble();
			d2 = sc1.nextDouble();

			double avg = (d1+d2)/2;
			System.out.println(avg);
		}else {
			System.out.println("Exception has ouccered");
		}
		sc.close();
		sc1.close();
	}
	
}