package onboarding;

public class Problem4 {

	public static String solution(String word) {
		return Converter.convert(word);
	}

	public static class Converter {

		public static String convert(String word) {
			return null;
		}

		public static boolean isLowerCaseAlphabet(char cur) {
			return 'a' <= cur && cur <= 'z';
		}

		public static boolean isUpperCaseAlphabet(char cur) {
			return 'A' <= cur && cur <= 'Z';
		}

	}

}
