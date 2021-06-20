package Listeners;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class listenerTest

{
	
	@Test
	public void loginbyEmail()
	{
		System.out.println("Login by email");
		Assert.assertEquals("Pri", "Pri");
	}
	
	@Test
	public void loginbyFacebook()
	{
		System.out.println("Login by email");
		Assert.assertEquals("Pri", "Pris");
	}
}
