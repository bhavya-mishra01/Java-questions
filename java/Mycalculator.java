import java.io.*;
class Calculator{
    double x,y;
    //method for addition
    double addition(int a, int b){
        return x+y;
    }
    //method for subtraction
     double subtractiob(int a, int b){
        return x-y;
    }
     //method for division
     double division(int a, int b){
        return x/y;
    }
     //method for multiplication
     double multiplication(int a, int b){
        return x+y;
    }
     //method for square
     double square(int a){
        return a*a ;
    }

}
class Mycalculator{
    public static void main(String args[])
    {
        Float x, y;
        DataInputStream in= new DataInputStream(System.in);
        String number;
        System.out.println("Enter first number: ");
        System.out.flush();
        number=in.readLine();
        x= Float.valueOf(number);
        System.out.println(x);
    }
}