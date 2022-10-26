package onboarding;

public class Problem4 {
	public static String solution(String word) {
		char[] chars = word.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			char temp = chars[i];
			if (temp >= 'A' && temp <= 'Z') {
				temp = (char) ('Z' - (temp - 'A'));
			} else if (temp >= 'a' && temp <= 'z') {
				temp = (char) ('z' - (temp - 'a'));
			}
			chars[i] = temp;
		}
		return String.valueOf(chars);
	}
}
