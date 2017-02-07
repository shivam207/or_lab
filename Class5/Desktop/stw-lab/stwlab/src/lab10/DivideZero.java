package lab10;

class DivideZero {

 static int anyFunction (int x, int y ){

 int a=0;

 try {
 a = x/y;

 }

 catch (ArithmeticException e)

 {

 System.out.println ("a = x/y is bypassed Enter y as non-zero");
		
 }

 return(a);
 }

 public static void main (String args [ ] ) {

 int result = anyFunction (25, 0) ;

 // Exception occurs here as y = 0

 System.out.println ("Result:"+result );

 }}

