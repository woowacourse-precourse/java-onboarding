package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
	private static final List<Character> clap = new ArrayList<>(Arrays.asList('3', '6', '9'));

	public static int solution(int number) {
		int answer = 0;
		return answer;
	}

	public static boolean isClap(char c) {
		if (clap.contains(c)) {
			return true;
		}

		return false;
	}
}
