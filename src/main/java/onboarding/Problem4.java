package onboarding;

public class Problem4 {
	
	public static char getChar(char c)
	{
		if ('a' <= c && c <= 'z')
		{
			return "zyxwvutsrqponmlkjihgfedcba".charAt(c - 'a');
		}
		if ('A' <= c && c <= 'Z')
		{
			return "ZYXWVUTSRQPONMLKJIHGFEDCBA".charAt(c - 'A');
		}
			
		return c;
	}
	
    public static String solution(String word) {
    	String str = new String();
		
		for (int i = 0; i < word.length(); i++)
			str += getChar(word.charAt(i));
		
		return str;
    }
}
