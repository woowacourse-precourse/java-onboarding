package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        
        for(char spell : word.toCharArray()) {
        	frog(spell);
        }
        
        return answer;
    }
    
    public static char frog(char spell) {
    	int ascii = (int)spell;
    	System.out.println(ascii);
    	
    	return spell;
    }
}
