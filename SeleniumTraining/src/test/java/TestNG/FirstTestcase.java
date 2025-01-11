package TestNG;

import org.testng.annotations.Test;

public class FirstTestcase 
{

	@Test(priority=1)
	void openApp() {
		System.out.println("Opening application...........");
	}
	
	@Test(priority=2)
	void login() {
		System.out.println("Logining...........");	
	}
	
	@Test(priority=3)
	void logout() {
		System.out.println("Log out of application...........");
	}
	
	
}
