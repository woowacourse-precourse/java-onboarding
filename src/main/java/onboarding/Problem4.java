package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	/* Character를 ascii코드로 Map에 추가 */
	public static Map<Character,Character> 
	frogDictionary(){
		Map<Character, Character> dictionary= new HashMap<Character, Character>();
		
		dictionary.put(' ', ' '); //공백은 반전할 게 없으므로 키와 값을 같게 설정
		
		Character capital=90; //대문자 Z
		for(Character i=65;i<=90;i++) { //대문자 A부터 시작
			dictionary.put(i, capital);
			capital--;
		}
		
		Character small=122; //소문자 a
		for(Character i=97;i<=122;i++) { //소문자 a부터 시작
			dictionary.put(i, small);
			small--;
		}
		
		return dictionary;
	}
	
    public static String solution(String word) {
        String answer = "";
        List<Character> wordList=convertStringToCharList(word);
		Map<Character, Character> dictionary=frogDictionary();
		
		
        return answer;
    }
}
