package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
	private static Set<String> emails;
	private static Map<String, String> keys; // word, email

	public static List<String> solution(List<List<String>> forms) {

		emails = new HashSet<>();
		keys = new HashMap<>();

		for (List<String> form : forms) {
			String nickname = form.get(1);
			if (nickname.length() > 1) {
				String email = form.get(0);
				checkInTwoLetters(nickname, email);
			}
		}

		return sortSet();
	}

	private static void checkInTwoLetters(String nickname, String email) {
		for (int i = 0; i < nickname.length() - 1; i++) {
			String key = nickname.substring(i, i + 2);
			if (keys.containsKey(key)) {
				String keyMail = keys.get(key);
				checkExistKey(keyMail, email);
			} else {
				keys.put(key, email);
			}
		}
	}

	private static void checkExistKey(String keyMail, String email) {
		if (!email.equals(keyMail)) {
			emails.add(email);
			emails.add(keyMail);
		}
	}

	private static List<String> sortSet() {
		List<String> target = new ArrayList<>(emails);
		Collections.sort(target);
		return target;
	}
}
