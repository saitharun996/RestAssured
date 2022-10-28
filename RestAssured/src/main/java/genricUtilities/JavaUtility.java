package genricUtilities;

import java.util.Random;

public class JavaUtility {

	public static int generateRandomNumber() 
	{
		Random r=new Random();
		int randomNumber = r.nextInt(2000); //nextInt method we are use for integers.
		
		return randomNumber;

	}

}
