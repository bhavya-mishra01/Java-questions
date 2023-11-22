// This is the class named School
class School { 
    // This is a method in class School
    public void print() { 
		System.out.println("Hi! I class SCHOOL."); 
    } 
} 
// This is the class named Student
class Student { 
	// This is a method in class Student
    public void print() { 
		System.out.println("Hi! I am class STUDENT"); 
    } 
}

public class ex_1{ 
    public static void main(String args[]){

// Create an object of class Student
Student s2= new Student();

// Call 'print()' method of class Student 
s2.print();
// Create an object of class School
School s1=new School();

// Call 'print()' method of class School
s1.print();

     
     

     } 
}
