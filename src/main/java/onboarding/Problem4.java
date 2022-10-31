package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class constant {
	static final String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
	static final String invalidArgument = "InvalidArgument";
	static final int length = 26;

}

class validateString {
	public static boolean isLower(String alphabet) {
		return alphabet.matches(alphabet.toLowerCase());
	}

	public static boolean isvalidLength(String word) {
		return (word.length() >= 1) && (word.length() <= 1000);
	}

	public static boolean isAlphabet(String alphabet) {
		return alphabet.chars().allMatch(Character::isLetter);
	}
}

class frog {
	private static int index;
	private static int changedIndex;

	public static void setIndex(int alphabetIndex) {
		index = alphabetIndex;
	}

	public static void setChangedIndex(int index) {
		changedIndex = constant.length - index - 1;
	}

	public static String changeWord(String alphabet) {
		if (validateString.isLower(alphabet) && validateString.isAlphabet(alphabet)) {
			setIndex(constant.lowerAlphabet.indexOf(alphabet));
			setChangedIndex(index);
			return constant.lowerAlphabet.substring(changedIndex, changedIndex + 1);
		}
		if (!validateString.isLower(alphabet) && validateString.isAlphabet(alphabet)) {
			setIndex(constant.upperAlphabet.indexOf(alphabet));
			setChangedIndex(index);
			return constant.upperAlphabet.substring(changedIndex, changedIndex + 1);
		}
		return " ";
	}
}

public class Problem4 {
	public static String solution(String word) {
		String answer = "";
		if (!validateString.isvalidLength(word)) {
			return constant.invalidArgument;
		}
		List<String> list = Arrays.asList(word.split(""));
		word = list.stream()
			.map(i -> frog.changeWord(i))
			.collect(Collectors.joining());
		answer = word;
		return answer;
	}
}
