package lab3;
import java.util.Scanner;
public class Dog {
	
	String name;
	int age;
	void setName(String n){ 
		name = n;
	}
	void bark()
	{System.out.println("ruff!! my name is "+name);}
 
	public static void main(String[ ] args){
		Scanner reader=new Scanner(System.in);
		Dog d;
		d=new Dog();
		System.out.println("enter name");
		String s=reader.nextLine();
		d.setName(s);
		d.bark();
	}
	

}
