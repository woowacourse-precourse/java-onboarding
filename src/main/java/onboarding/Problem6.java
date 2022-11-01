package onboarding;

import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");
		return answer;
	}

	public static boolean dupleCheck(String target, String compare) {
		char[] targetWord = target.toCharArray();

		for(int i = 0; i <targetWord.length - 1; i++) {
			if(compare.contains("" + targetWord[i] + targetWord[i + 1])) {
				return true;
			}
		}

		return false;
	}
}
