package Listeners;

public class Listeners

{
	
	public void OnTestStart()
	{
		System.out.println("Test started");
	}
	
	public void OnTestSuccess()
	{
		System.out.println("Test Passed");
	}
	
	public void OnTestFailure()
	{
		System.out.println("Test Failed");
	}
	
	public void OnTestSkipped()
	{
		System.out.println("Test Skipped");
	}

}
