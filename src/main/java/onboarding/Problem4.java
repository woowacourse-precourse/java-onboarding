package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
	private static class Constant {
		static final String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		static final String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		static final String invalidArgument = "InvalidArgument";
		static final int length = 26;
	}

	private static class ValidatationString {
		public static boolean isLower(String alphabet) {
			return alphabet.matches(alphabet.toLowerCase());
		}

		public static boolean isValidLength(String word) {
			return (word.length() >= 1) && (word.length() <= 1000);
		}

		public static boolean isAlphabet(String alphabet) {
			return alphabet.chars().allMatch(Character::isLetter);
		}
	}

	private static class Frog {
		private static int index;
		private static int changedIndex;

		public static void setIndex(int alphabetIndex) {
			index = alphabetIndex;
		}

		public static void setChangedIndex(int index) {
			changedIndex = Constant.length - index - 1;
		}

		public static String changeWord(String alphabet) {
			if (ValidatationString.isLower(alphabet) && ValidatationString.isAlphabet(alphabet)) {
				setIndex(Constant.lowerAlphabet.indexOf(alphabet));
				setChangedIndex(index);
				return Constant.lowerAlphabet.substring(changedIndex, changedIndex + 1);
			}
			if (!ValidatationString.isLower(alphabet) && ValidatationString.isAlphabet(alphabet)) {
				setIndex(Constant.upperAlphabet.indexOf(alphabet));
				setChangedIndex(index);
				return Constant.upperAlphabet.substring(changedIndex, changedIndex + 1);
			}
			return " ";
		}
	}

	public static String solution(String word) {
		String answer = "";
		if (!ValidatationString.isValidLength(word)) {
			return Constant.invalidArgument;
		}
		List<String> list = Arrays.asList(word.split(""));
		word = list.stream()
			.map(i -> Frog.changeWord(i))
			.collect(Collectors.joining());
		answer = word;
		return answer;
	}
}
