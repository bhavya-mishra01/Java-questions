public class Circle {
    static int Circlecount = 0; // global variable or class variable
    public double x, y, r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;

    }
     //CONSTRUCTOR OVERLOADING
    public Circle(double r) { //contructor
        this(0.0, 0.0, r);
        Circlecount++;
    }

    public Circle(Circle c) {
        this(c.x, c.y, c.r);
        Circlecount++;
    }

    public Circle() {
        this(0.0, 0.0, 0.1);
        Circlecount++;
    }

    public double circumference() {
        return (2 * 3.14159 * r);
    }

    public double area() {
        return (3.14159 * r * r);
    }

    public static void main(String args[]) {
        Circle c1 = new Circle();
        System.out.println("c1#" + c1.Circlecount);

        Circle c2 = new Circle(5.2);
        System.out.println("c2#" + c2.Circlecount);

        Circle c3 = new Circle(c1);
        System.out.println("c3#" + c3.Circlecount);
        System.out.println(" C1 # "+c1.Circlecount+ " C2# "+c2.Circlecount+" c3# "+c3.Circlecount);
    }

}
