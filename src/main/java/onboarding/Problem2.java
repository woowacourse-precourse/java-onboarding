package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
    	int	flag	= 0;
		
		while(flag == 0)
		{
			flag = 1;
			
			for(int i = 0; i + 1< cryptogram.length(); i++)
			{
				if(cryptogram.charAt(i) == cryptogram.charAt(i + 1))
				{
					cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
					flag = 0;
					break;
				}
			}
		}
		
		return cryptogram;
    }
}
