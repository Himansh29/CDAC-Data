import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point2D p1 = new Point2D(4, 7);
        Point2D p2 = new Point2D(4, 7);

        // toString Method
        System.out.println(p1.show());

        // Check if the objects has same values
        if(p1.isEqual(p2)) {
            System.out.println("Both the co-ordinates are equal");
        }else {
            System.out.println("Both the co-ordinates are not equals");
        }

        // Calculate distance between two co-ordinate
        double distanceBetweenTwoCoOrdiantes = p1.calculateDistance(p2);
        System.out.println(distanceBetweenTwoCoOrdiantes);
    } 
}