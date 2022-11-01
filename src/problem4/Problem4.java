package problem4;

public class Problem4 {
	public static String solution(char[] word) {
		
		for(int i=0; i<word.length; i++){
            
            if(Character.isAlphabetic(word[i])){
                if(Character.isUpperCase(word[i])){
                    char temp = (char)('Z' - (word[i] - 'A'));
                    word[i] = temp;
                }
                else{
                    char temp = (char)('z' - (word[i] - 'a'));
                    word[i] = temp;
                }
            }
        }
		
		String result = "";
		for(char c:word) result += c;
		
		return result;
		
	}
	
}

