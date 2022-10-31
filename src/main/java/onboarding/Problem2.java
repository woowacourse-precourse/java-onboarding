package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

	private static class Code{
		private ArrayList<Character> code;

		Code(String cryptogram) {
			this.code = Code.toArrayList(cryptogram);
		}

		private static ArrayList<Character> toArrayList(String cryptogram) {
			ArrayList<Character> code = new ArrayList<>();
			for (char currentLetter : cryptogram.toCharArray()) {
				code.add(currentLetter);
			}
			return code;
		}
	}
}
