package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	private static List<Character> convertStringToCharList(String str){

		List<Character> chars = new ArrayList<>();
		/* List 타입으로 변환 */
		for (char ch : str.toCharArray()) {

			chars.add(ch);
		}

		return chars;
	}
	
	public static String solution(String cryptogram) {
		String answer = "answer";
		List<Character> crptogramList = convertStringToCharList(cryptogram);
		
		
		return answer;
	}

}
