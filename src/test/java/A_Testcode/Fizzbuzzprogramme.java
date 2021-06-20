package A_Testcode;



public class Fizzbuzzprogramme 
{
	
	public void fizzbuzz()
	{
		int i;
		try
		{
			for(i=1;i<=50;i++)
			{
				if (i/3==0)
				{
					
					if (i/5==0)
					{
						System.out.println("FizzBuzz");
					}
					
					else {
						System.out.println("Fizz");
					}
				}
				
				if(i/5==0)
				{
				System.out.println("Buzz");
				}
				else
				{
				System.out.println(i);
				}
			}
			
			
		}
		catch(Exception e) {
			
		}
		}
	
	
}
	 