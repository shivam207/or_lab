package lab10;
import java.util.Scanner;
class A extends Thread {
	int n;
	//This is the entry point for thread.
	public void run() {
		try {
			for(int i = 5; i > 0; i--) {
				System.out.println("Child Thread: " +i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
		}
		System.out.println("Exiting child thread.");
	}
}

class ExtendDemo {
	public static void main(String args[]) {
		Thread a = new A(); // create a new thread
		a.start();
		try {
			for(int i = 5; i > 0; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted ");
		}
		System.out.println("Main thread exiting.");
	}
}


