



public class Demo1 {
    public static void main(String args[]){
        int a,b;
        a=5;b=0;
        try{
            int result;
            result=a/b;
            System.out.println("Exception handled!");
        }
        catch(Exception e){
            System.out.println("Exception caugth!");
        }
        finally{
            System.out.println("Parameter fulfilled!");
        }
        }
}