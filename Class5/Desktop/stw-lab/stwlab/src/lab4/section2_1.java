package lab4;
import java.util.Scanner;
import java.lang.Math.*;
interface polygon{
	float perimeter(float a,float b,float c);
	float area(float a,float b,float c);
}
class triangle implements polygon{ 

	public float area(float a,float b,float c){
		float s;
		s=(a+b+c)/2;
		return (float) (Math.sqrt(s*(s-a)*(s-b)*(s-c)));
	}
	public float perimeter(float a,float b,float c){
		return (a+b+c);
	}


}

class parallelogram implements polygon{

	public float area(float a,float b,float c){
		return (a*b);//a is a side and b is  distance from its parallel side
	}
	public float perimeter(float a,float b,float c){
		return (2*(a+c));// c is the other parallel side
	}

}
class hexagon implements polygon{
	public float area(float a,float b,float c){
		return (float) ((3*Math.sqrt(3)*a*a)/2);
	}
	public float perimeter(float a,float b,float c){
		return (6*a);
	}
}

class octagon implements polygon{ 
	public float area(float a,float b,float c){
		return (float) (2*(1+Math.sqrt(2)*a*a));
	}
	public float perimeter(float a,float b,float c){
		return 8*a;
	}
}

class isoscelesT extends triangle{
	float a,b;

	
	float area(){return super.area(a, a, b);}
	float pm(){return super.perimeter(a,a,b);}
	

}

class equilateralT extends triangle{
	float a;
	float area=super.area(a, a, a);
	float pm=perimeter(a,a,a);
}

class rectangle extends parallelogram{
	float a,b,c;
	float are=area(a,b,0);
	float pme=perimeter(a,0,c);
}

class square extends parallelogram{
	float a;
	float are=area(a,a,0);
	float pme=perimeter(a,0,a);
}

public class section2_1 {
	public static void main(String[ ] args){
		int ch; float x,y,z,ar,pm;
		polygon ref;
		Scanner input = new Scanner(System.in);
		System.out.println("enter choice ");
		System.out.println("1.scalene triangle"+
				"2.isosceles triangle"+
				"3.equilateral triangle"+
				"4.parallelogram"+
				"5.rectangle"+
				"6.square"+
				"7.regular hexagon"+
				"8.regular octagon");
		ch=input.nextInt( );
		switch(ch)
		{
		case 1:{ triangle obj=new triangle();
		System.out.println("enter sides ");

		x=input.nextInt( );
		y=input.nextInt( );
		z=input.nextInt( );
		if(x+y<z||y+z<x||z+x<y)
			System.out.println("sides not possible ");
		else{	
			ref=obj;



			ar=ref.area(x,y,z);
			pm=ref.perimeter(x,y,z);
			System.out.println("area="+ar+"perimeter="+pm);}

		break;}

		case 2:{isoscelesT obj=new isoscelesT();ref=obj;
		System.out.println("enter length of  eql sides& other side");
		x=input.nextInt( );
		y=input.nextInt( );
		if(x<y/2)
			System.out.println("sides not possible ");
		else{
			obj.a=x;
			obj.b=y;

			ar=obj.area();
			pm=obj.pm();
			
			System.out.println("area="+ar+"perimeter="+pm);}
		break;}
		case 3:{equilateralT obj=new equilateralT();ref=obj;
		System.out.println("enter side");
		x=input.nextInt();
		obj.a=x;
		ar=obj.area;
		pm=obj.pm;
		System.out.println("area="+ar+"perimeter="+pm);}
		break;}





	}

























}
