package AkhilRaj;

public class Q2 {

	public static void main(String[] args) {

		car testCar = new car(2015, "TATA", 53);
		
		System.out.println("Year : " + testCar.getYear() + "\nMaker : " + testCar.getMake() + "\nSpeed : " + testCar.getSpeed() + "kmph");
		testCar.accelerate();
		testCar.accelerate();
		System.out.println("New speed : " + testCar.getSpeed() + "kmph");
		testCar.accelerate();
		testCar.accelerate();
		testCar.accelerate();
		System.out.println("New speed : " + testCar.getSpeed() + "kmph");
	}

}


class car{
	
	int year;
	String make;
	double speed;
	
	car(int year, String make, double speed)
	{
		
		this.year = year;
		this.make = make;
		this.speed = speed;
		
	}
	
	int getYear()
	{
		return year;
	}
	
	String getMake()
	{
		return make;
	}
	
	double getSpeed()
	{
		return speed;
	}
	
	
	void accelerate()
	{
		
		speed += 5;
		
	}
}