package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
	private static final Map<String, Set<String>> duplicatedWordWithEmails = new HashMap<>();

	public static List<String> solution(List<List<String>> forms) {
		for (List<String> form : forms) {
			String email = form.get(0);
			String nickname = form.get(1);

			if (nickname.length() < 2) {
				continue;
			}

			addDuplicatedNicknameWord(email, nickname);
		}

		Set<String> answer = new TreeSet<>();
		for (Set<String> emails : duplicatedWordWithEmails.values()) {
			if (emails.size() < 2) {
				continue;
			}
			answer.addAll(emails);
		}
		return List.copyOf(answer);
	}

	private static void addDuplicatedNicknameWord(String email, String nickname) {
		for (int i = 1; i < nickname.length(); i++) {
			String nicknameSubstr = nickname.substring(i - 1, i + 1);
			Set<String> emails = duplicatedWordWithEmails.getOrDefault(nicknameSubstr, new HashSet<>());
			emails.add(email);
			duplicatedWordWithEmails.put(nicknameSubstr, emails);
		}
	}
}
