//public class Question_43 {
    
//}
interface ExtraLarge{
	static String extra = "This is extra-large";
	void display();
}

class Large {
    public void Print() {
        System.out.println("This is large");
    }
}
 
class Medium extends Large {
    public void Print() {
        System.out.println("This is medium");
    	super.Print();  
    }
}
class Small extends Medium {
    public void Print() {
        System.out.println("This is small");
        super.Print();  
    }
}
class Question_43 implements ExtraLarge{
    public static void main(String[] args) {
        Small s = new Small();
        s.Print();
		Question_43 q = new Question_43();
		q.display();
    }
	public void display(){
		//System.out.println(extra);
	}
} 