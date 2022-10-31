package onboarding;

public class Problem4 {

	public static String solution(String word) {
		String answer = "";

		answer = wordCheck(word).toString();

		return answer;
	}

	public static StringBuilder wordCheck(String word) {
		StringBuilder builder = new StringBuilder();

		for(int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			int distance = 0;

			if(65 <= character && character <= 90) {
				distance = 90 - character;
				character = (char) (65 + distance);
			} else if(97 <= character && character <= 122) {
				distance = 122 - character;
				character = (char) (97 + distance);
			}

			builder.append(character);
		}

		return builder;
	}

}
