package lab9;

import java.util.Scanner;



interface polygon{
	float perimeter();
	float area();
}
class triangle implements polygon{ 
     float a,b,c;
     triangle(float x,float y,float z){
    	 a=x;
    	 b=y;
    	 c=z;
     }
	public float area(){
		float s;
		s=(a+b+c)/2;
		return (float) (Math.sqrt(s*(s-a)*(s-b)*(s-c)));
	}
	public float perimeter(){
		return (a+b+c);
	}


}




class isoscelesT extends triangle{
	isoscelesT(float x, float y, float z) {
		super(x, y, z);
	}
	
	 isoscelesT(float x, float y){
		 super(x,x,y);
	 }

	
	public float area(){
		return super.area();
		}
	public float perimeter(){
		return super.perimeter();
		}
	

}

class equilateralT extends triangle{
	equilateralT(float x) {
		super(x, x, x);
	}
	float a;
	public float area(){
		return super.area();
	}
	public float perimeter(){
		return super.perimeter();
	}
}



public class Section2_1 {
	public static void main(String[ ] args){
		int ch; float x,y,z,ar,pm;
		polygon ref;
		Scanner input = new Scanner(System.in);
		System.out.println("enter choice ");
		System.out.println("1.scalene triangle"+
				"2.isosceles triangle"+
				"3.equilateral triangle"
				);
		ch=input.nextInt( );
		switch(ch)
		{
		case 1:{ 
		System.out.println("enter sides ");

		x=input.nextInt( );
		y=input.nextInt( );
		z=input.nextInt( );
		if(x+y<z||y+z<x||z+x<y)
			System.out.println("sides not possible ");
		else{	
			triangle obj=new triangle(x,y,z);
			ref=obj;



			ar=ref.area();
			pm=ref.perimeter();
			System.out.println("area="+ar+"perimeter="+pm);}

		break;}

		case 2:{
		System.out.println("enter length of  eql sides& other side");
		x=input.nextInt( );
		y=input.nextInt( );
		if(x<y/2)
			System.out.println("sides not possible ");
		else{isoscelesT obj=new isoscelesT(x,x,y);ref=obj;
			obj.a=x;
			obj.b=y;

			ar=ref.area();
			pm=ref.perimeter();
			
			System.out.println("area="+ar+"perimeter="+pm);}
		break;}
		case 3:{
		System.out.println("enter side");
		x=input.nextInt();
		equilateralT obj=new equilateralT(x);ref=obj;
		obj.a=x;
		ar=obj.area();
		pm=obj.perimeter();
		System.out.println("area="+ar+"perimeter="+pm);}
		break;}





	}

























}

