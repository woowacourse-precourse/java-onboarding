package onboarding;

import onboarding.problem4.ConvertingReverseWord;

public class Problem4 {
	public static String solution(String word) {
		ConvertingReverseWord reverseWord = new ConvertingReverseWord();
		String answer = reverseWord.process(word);
		return answer;
	}
}


