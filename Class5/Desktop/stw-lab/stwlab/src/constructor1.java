package lab9;



class box {

 double width,height,depth;

 box() {

 System.out.println("In Box Constructor");

 width = 10;

 height = 10;

 depth = 10;

 }
 box(float w){
	 width=w;
 }
box(float w,float h,float d){
	width=w;
	height=h;
	depth=d;
}
 void volume() { System.out.println("Volume is "

+ width *height * depth);}

 }

 public class   constructor1{

 public static void main(String args[]) {

 box b1 = new box();

 b1.volume();
 box b2=new box(1);
 b2.volume();
 box b3=new box(1,2,3);
 b3.volume();
 
 

 }
 }


