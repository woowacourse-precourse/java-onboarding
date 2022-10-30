package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
		if (cryptogram.length() == 1) {
			return cryptogram;
		}
		List<Character> list = new ArrayList<>();
		for (char c : cryptogram.toCharArray()) {
			add(list, c);
		}
		for (Character character : list) {
			answer.append(character);
		}
        return answer.toString();
    }

	private static void add(List<Character> list, char c) {
		list.add(c);

		if (1 < list.size() && isEqualOfTwoChars(list)) {
			list.remove(list.size() - 1);
			list.remove(list.size() - 1);
		}
	}

	private static boolean isEqualOfTwoChars(List<Character> list) {
		return list.get(list.size() - 2) == list.get(list.size() - 1);
	}
}
