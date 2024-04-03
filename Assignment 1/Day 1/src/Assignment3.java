import java.util.Scanner;

class Assignment3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int finalAnswer = 1;

        boolean flag = false;

        while(!flag) {
            System.err.println("Press 1 for Addition");
            System.out.println("Press 2 for subtraction");
            System.out.println("Press 3 to multiply");
            System.out.println("Press 4 for division");
            System.out.println("Press 5 exit");
            
            int option = sc.nextInt();
            switch(option) {
                case 1: {
                    int a,b;
                    System.out.println("Enter 2 variables for addition: ");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    finalAnswer += (a+b);
                    break;
                }
                case 2:{
                    int a,b;
                    System.out.println("Enter 2 variables for subtration: ");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    finalAnswer -= (a+b);
                    break; 
                }

                case 3:{
                    int a,b;
                    System.out.println("Enter 2 variables for multiplication: ");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    finalAnswer *= (a+b);
                    break; 
                }

                case 4: {
                    int a,b;
                    System.out.println("Enter 2 variables for Division: ");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    finalAnswer /= (a+b);
                    break; 
                }

                case 5:
                    flag = true;
                    break;
            }
        }

        System.out.println("Final answer is: " + finalAnswer);
    }
}