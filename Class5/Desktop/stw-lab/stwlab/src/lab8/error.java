package lab8;
final class A{

 final int i = 10;

 int foo(){return i;}

}

class B extends A{
int i;
 

int foo(){
 this.i=5; return i*i;
 }

 }
public class error {
	public static void main(String[ ] args){
	B obj=new B();
	
	System.out.println(obj.foo());
}}
