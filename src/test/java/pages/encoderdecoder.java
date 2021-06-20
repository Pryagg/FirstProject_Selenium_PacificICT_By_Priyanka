package pages;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

import org.testng.annotations.Test;

public class encoderdecoder 
{
	//@Test
	public void encodedecodemessaage()
	{
		String str = "Hello World";
		byte[] bytes = str.getBytes();
		String encoded = Base64.getEncoder().encodeToString(bytes);
		System.out.println(encoded);
		byte[] decoded = Base64.getDecoder().decode(encoded);
		System.out.println(decoded);
				
	}

@Test
	public void Embeddedimage()
	{
		try
		{
			String urltext = "C:\\Users\\priyanka\\Desktop\\Selenium Projects\\FirstProject\\Results\\Screenshots\\1_Login to the HomePage_Passed.png";
			URL url= new URL(urltext);
			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			
			byte[] imagebytes = new byte[0];
			
			for(byte[] ba = new byte[bis.available()];
			        bis.read(ba) != -1;) 
			{
			        byte[] baTmp = new byte[imagebytes.length + ba.length];
			        System.arraycopy(imagebytes, 0, baTmp, 0, imagebytes.length);
			        System.arraycopy(ba, 0, baTmp, imagebytes.length, ba.length);
			        imagebytes = baTmp;
			    }
			
			System.out.println("<img src='data:image/png;base64," + DatatypeConverter.printBase64Binary(imagebytes) + "'>");
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
