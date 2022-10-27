package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";
		
		for (int i = 0; i < word.length(); i++) {
			char target = word.charAt(i);
			
			int charType = charCheck(target);
			if(charType == 0){
				answer += target;
				continue;
			}
			
			char changedTarget = changeByDictionary(target,charType);
			answer += changedTarget;
		}
		return answer;
	}
	
	private static char changeByDictionary(char target,int charType) {
			if(charType == 1){
				int offset = target - 'A';
				return (char)('Z' - offset);
			}
			
			if(charType == 2){
				int offset = target - 'a';
				return (char) ('z' - offset);
			}
		
		new Exception("에러발생");
		return 0;
	}
	
	private static int charCheck(char c) {
		if('A' <= c && c <= 'Z'){
			return 1;
		}
		if('a' <= c && c <= 'z'){
			return 2;
		}
		return 0;
	}
}
