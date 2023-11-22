import java.util.Scanner;

public class Area_circle {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter radius of circle:");
        double r= sc.nextDouble();
        double ar= r*r*22/7;
        System.out.println("Area of circle=" + ar);
    }
}
