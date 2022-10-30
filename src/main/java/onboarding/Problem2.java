package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
		if (cryptogram.length() == 1) {
			return cryptogram;
		}
		List<Character> list = new ArrayList<>();
		for (char c : cryptogram.toCharArray()) {
			add(list, c);
		}
        return answer;
    }

	private static void add(List<Character> list, char c) {
		list.add(c);
	}
}
