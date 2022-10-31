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
    	System.out.println("변환 전 : " + ascii);
    	
    	if(ascii>=65&&ascii<=90) {
    		ascii = 155-ascii;
    	}
    	System.out.println("변환 후 : " + ascii);
    	spell = (char)ascii;
    	
    	return spell;
    }
}
