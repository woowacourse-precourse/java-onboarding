package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
	private static final List<Character> clap = new ArrayList<>(Arrays.asList('3', '6', '9'));

	public static int solution(int number) {
		int answer = 0;

		for (int i = 1; i <= number; i++) {
			answer += checkNumber(i);
		}

		return answer;
	}

	public static int checkNumber(int number) {
		int tmp = 0;
		char[] num = String.valueOf(number).toCharArray();
		for (char c : num) {
			if (isClap(c)) {
				tmp += 1;
			}
		}
		return tmp;
	}

	public static boolean isClap(char c) {
		if (clap.contains(c)) {
			return true;
		}

		return false;
	}
}
