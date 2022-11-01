package onboarding;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem4 {
	public static String solution(String word) {
		validateWord(word);
		
		String wordArray = Arrays
				.stream(word.split(""))
				.map(x->getTreeForgWord(x))
				.collect(Collectors.joining());

		return wordArray;
	}

	/**
	 * 주어진 문자열에 대한 유효성 검사
	 * @param word
	 */
	public static void validateWord(String word) {
		if(word.length() > 1000 || word.length() < 1) throw new IllegalArgumentException();
	}

	/**
	 * 주어진 문자열에 대한 청개구리 언어를 반환한다.
	 * @param word
	 * @return
	 */
	public static String getTreeForgWord(String word){
		int aschiiNum = (int) word.charAt(0);

		// 아스키코드를 사용하여 대문자는 대문자로, 소문자는 소문자로 변환한다.
		if(aschiiNum <= 90 && aschiiNum >= 65) return String.valueOf((char) (155-aschiiNum));
		if(aschiiNum <= 122 && aschiiNum >= 97) return String.valueOf((char) (219-aschiiNum));

		// 알파벳 대문자, 소문자가 아닐 경우 공백을 반환한다.
		return " ";
	}
}
