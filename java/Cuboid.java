import java.nio.channels.AsynchronousByteChannel;
import java.util.Scanner;

public class Cuboid {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter length, breadth and height of cuboid:");
        double l= sc.nextDouble();
        double b= sc.nextDouble();
        double h= sc.nextDouble();
        double volume=l*b*h;
        double surface_area= 2*(l*b+b*h+h*l);
        System.out.println("Volume="+volume);
        System.out.println("Surface area="+surface_area);
    }
}
