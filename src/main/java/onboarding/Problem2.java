package onboarding;

import java.util.ArrayList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

	private static class Code{
		private final static char EMPTY_LETTER = '0';
		private boolean isPerfectlyCracked = false;
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

		private void removeRepetition() {
			char repeatedLetter = EMPTY_LETTER;
			char formerLetter = EMPTY_LETTER;
			Stack<Character> crackedCode = new Stack<>();

			for (Character letter : code) {
				if (formerLetter != letter) {
					crackedCode.push(letter);
					formerLetter = letter;
					repeatedLetter = EMPTY_LETTER;
					continue;
				}
				if (letter != repeatedLetter) {
					repeatedLetter = crackedCode.pop();
				}
			}

			isPerfectlyCracked = crackedCode.isEmpty() || code.equals(crackedCode);
			code = new ArrayList<>(crackedCode);
		}

		public String toCrackedCode() {
			while (!isPerfectlyCracked) {
				removeRepetition();
			}
			StringBuilder crackedCode = new StringBuilder();
			code.forEach(crackedCode::append);
			return crackedCode.toString();
		}
	}
}
