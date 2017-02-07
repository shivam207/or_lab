package lab9;

 class A{
	int a;
	char b;
	 double c;
	
	A(){
       a=7;
       b='k';
       c= 108.0;
   	System.out.println("inside constructor A()");
		}
}
	 class B{
		int a;
		char b;
		 double c;
		
		B(){
	       a=14;
	       b='R';
	       c= 864.0;
	   	System.out.println("INSIDE CONSTRUCTOR B()");	
		}
		
	
}
	 class C extends A{
		int a;char b;double c;  B objb;
			C(){ 
				System.out.println("inside constructor c");
				objb = new B();
				a=super.a;
		        b=super.b;
		        c=super.c;
		     
			}
		
         
		
	}
	
public class Section2_3                     /*when object of a subclass is made then first constructor of its super class is called first
                                                and if the super class itself inheriting from other class then constructor of that class is called,similarly so on
                                                 h */
{
	public static void main(String[ ] args)
	{
	 C objc=new C();
    } 
	 
}
