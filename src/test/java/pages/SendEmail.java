package pages;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class SendEmail 
{
	//@Test
	public void SendEmail_Gmail()
	{
		try
		{
			System.out.println("Email started sending");
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			//email.setSSLOnConnect(true);
			// Add username and Password
			email.setAuthenticator(new DefaultAuthenticator("pryagg0711@gmail.com", "password"));
			email.setSSLOnConnect(true);
			// do some setting change in Gmail (see selenium link , how to send email through Jenkins added to bookmark)
			email.setFrom("pryagg0711@gmail.com");
			email.setSubject("TestMail");
			email.setMsg("This is a test mail ... :-)");
			email.addTo("priyanka@pacificict.co.nz");
			email.send();			
			System.out.println("Email sent");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	public void sendemail_outlook()
	{
		try
		{
			System.out.println("Email started sending");
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			//email.setSSLOnConnect(true);
			email.setAuthenticator(new DefaultAuthenticator("piku.aggarwal0711@gmail.com", "priyanka0711"));
			email.setSSLOnConnect(true);
			email.setFrom("priyanka.aggarwal0711@gmail.com");
			email.setSubject("TestMail");
			email.setMsg("This is a test mail ... :-)");
			email.addTo("priyanka@pacificict.co.nz");
			email.send();			
			System.out.println("Email sent");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	
		//@Test
//Function sending email through new automation email created
	public void SendEmailmethod2()
	{
		try
		{
			  // Create the attachment
			  EmailAttachment attachment = new EmailAttachment();
			  //attachment.setPath("Results\\Screenshots\\acceptterms_Passed.png");
			  attachment.setPath(".\\Results\\extentReports.html");
			  attachment.setDisposition(EmailAttachment.ATTACHMENT);
			  attachment.setDescription("Picture of testscenario");
			  attachment.setName("Pri");

			  // Create the email message
			  MultiPartEmail email = new MultiPartEmail();
			  //need to check the server
			  //email.setHostName("mail.myserver.com");
			  // server name is taken from IT team 
			  email.setHostName("et-svr-sid-ex4.siddall.local");
			 // email.setSslSmtpPort("465");
			  email.addTo("priyanka@pacificict.co.nz", "Priyanka Agg");
			  email.setFrom("automated_testing@pacificict.co.nz", "Automation Test email");
			  //email.setAuthentication("automated_testing@pacificict.co.nz", "zxN$qX1RJ3wd");			  
			  email.setSubject("Automatic mail functionality test");
			  email.setMsg("Here is the picture you wanted");
			  // add the attachment
			  email.attach(attachment);
			  // send the email
			  email.send();

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	//@Test
	//function with taking arguments from user and sending email through dedicated email set for automation
	public void SendEmailmethod_2(String screenshotpath, String Description, String sendtoemail, String sendfrom)
	{
		try
		{
			  // Create the attachment
			  EmailAttachment attachment = new EmailAttachment();
			  attachment.setPath(screenshotpath);
			  attachment.setDisposition(EmailAttachment.ATTACHMENT);
			  attachment.setDescription(Description);
			  attachment.setName("Pri");

			  // Create the email message
			  MultiPartEmail email = new MultiPartEmail();
			  //need to check the server
			  //email.setHostName("mail.myserver.com");
			  // server name is taken from IT team 
			  email.setHostName("et-svr-sid-ex4.siddall.local");
			 // email.setSslSmtpPort("465");
			  email.addTo(sendtoemail, "Priyanka Agg");
			  email.setFrom(sendfrom, "Automation Test email");
			  //email.setAuthentication("automated_testing@pacificict.co.nz", "zxN$qX1RJ3wd");			  
			  email.setSubject("Automatic mail functionality test");
			  email.setMsg("Screenshots of test cases");			  
			  // add the attachment
			  email.attach(attachment);
			  // send the email
			  email.send();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
      @Test
		public void callsendemailfunction()
		{
			//SendEmailmethod_2(".\\Results\\extentReports.html", "extent Report", "priyanka@pacificict.co.nz", "automated_testing@pacificict.co.nz");
    	  System.out.println("pri");  
    	  System.out.println("User dir:" + System.getProperty("user.dir"));
		}
	
	
	
}
