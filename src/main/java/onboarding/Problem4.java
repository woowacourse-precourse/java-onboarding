package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
	
	/* String 타입을 List로 형변환 */
	public static List<Character> 
	convertStringToCharList(String str){
  
        List<Character> chars = new ArrayList<>();
  
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
  
        return chars;
    }
	
	
    public static String solution(String word) {
        String answer = "";
        List<Character> wordList=convertStringToCharList(word);
		
        return answer;
    }
}
