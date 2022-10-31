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
	private static List<Character> removeOverlapChar(List<Character> crptogramList) {
		int i=0;
		while(true) {
			if(i==crptogramList.size()-1||crptogramList.size()==0) {
				break;
			}
			char a=crptogramList.get(i);
			char b=crptogramList.get(i+1);
			if(a == b) {
				crptogramList.remove(i+1);
				crptogramList.remove(i);
				i=0;
				continue;
			}
			i++;
		}
		return crptogramList;
	}
	private static String convertCharListToString(List<Character> str){

		StringBuilder sb = new StringBuilder();

		for (Character ch : str) {
			sb.append(ch);
		}

		String answer = sb.toString();
		return answer;
	}
	public static String solution(String cryptogram) {
		String answer = "answer";
		
		List<Character> crptogramList = convertStringToCharList(cryptogram);
		
		crptogramList = removeOverlapChar(crptogramList);
		
		answer = convertCharListToString(crptogramList);
		
		return answer;
	}

}
