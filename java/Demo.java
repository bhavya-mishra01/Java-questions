import java.util.*;

class Number {
    private double a, b, sum, sub, div, mul;

    public void input(double x, double y) {
        a = x;
        b = y;
    }

    public void add() {
        sum = a + b;
        System.out.println("Sum=" + sum);
    }

    public void sub() {
        sub = a - b;
        System.out.println("Diffrence=" + sub);
    }

    public void div() {
        div = a / b;
        System.out.println("Quotient=" + div);
    }

    public void mul() {
        mul = a * b;
        System.out.println("Product=" + mul);
    }

}

class Demo {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        double num1 = s.nextDouble();
        double num2 = s.nextDouble();
        Number c = new Number();
        c.input(num1, num2);
        System.out.println("Choose your operation!");
        System.out.println("1: Add \n2: Subtract \n3: Divide \n4: Multiply");
        int op = s.nextInt();
        switch (op) {
            case 1:
                c.add();
                break;
            case 2:
                c.sub();
                break;
            case 3:
                c.div();
                break;
            case 4:
                c.mul();
                break;
            default:
                System.out.println("Invalid choice! Try Again!");
                break;
        }
    }
}
