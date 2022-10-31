package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        
        for(char spell : word.toCharArray()) {
        	answer += frog(spell);        	 
        }
        
        return answer;
    }
    
    public static char frog(char spell) {
    	int ascii = (int)spell;
    	
    	if(ascii>=65&&ascii<=90) ascii = 155-ascii;
    	else if(ascii>=97&&ascii<=122) ascii = 219-ascii;
    	
    	spell = (char)ascii;
    	
    	return spell;
    }
}
