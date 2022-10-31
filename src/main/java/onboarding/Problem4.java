package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Problem4 problem4 = new Problem4();
        
        for(char alphabet : word.toCharArray()) {
        	answer += problem4.frogTranslate(alphabet);
        }//for
        
        return answer;
    }// solution
    
    private char frogTranslate(char alphabet) {
    	if( 'A'<= alphabet && alphabet <='M') return (char)('Z'+('A'-alphabet));
    	if( 'N'<= alphabet && alphabet <='Z') return (char)('A'+('Z'-alphabet));
    	if( 'a'<= alphabet && alphabet <='m') return (char)('z'+('a'-alphabet));
    	if( 'n'<= alphabet && alphabet <='z') return (char)('a'+('z'-alphabet));
    	return alphabet;
    }// frogTranslate
}// end class
