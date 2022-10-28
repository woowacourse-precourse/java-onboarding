package onboarding;

public class Problem4 {
	public static String solution(String word) {
		ReverseCharacter reverseCharacter = new ReverseCharacter(word);
		String answer = reverseCharacter.run();
		return answer;
	}
}
