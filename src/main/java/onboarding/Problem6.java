package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
	private static Set<String> emails = new HashSet<>();
	private static Map<String, String> keys = new HashMap<>(); // word, email

	public static List<String> solution(List<List<String>> forms) {

		for (List<String> form : forms) {
			String nickname = form.get(1);
			if (nickname.length() < 2) {
				continue;
			}

			String email = form.get(0);
			for (int j = 0; j < nickname.length() - 1; j++) {
				String key = nickname.substring(j, j + 2);
				if (keys.containsKey(key)) {
					String keyMail = keys.get(key);
					checkExistKey(keyMail, email);
				} else {
					keys.put(key, email);
				}
			}
		}
		
		return sortSet();
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
