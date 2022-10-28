package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		Set<String> duplicateTokens = new HashSet<>();
		Set<String> answer = new TreeSet<>();
		List<User> userList = forms.stream()
				.map(User::new)
				.collect(Collectors.toList());

		for (User user : userList) {
			for (String token : duplicateTokens) {
				if (user.checkDuplicate(token)) {
					answer.addAll(getDuplicateEmails(userList, token));
				}
			}
			duplicateTokens.addAll(user.getDuplicateNicknameTokens());
		}

		return List.copyOf(answer);
	}

	private static List<String> getDuplicateEmails(List<User> userList, String token) {
		List<String> duplicateEmails = new ArrayList<>();
		for (User targetUser : userList) {
			if (targetUser.checkDuplicate(token)) {
				duplicateEmails.add(targetUser.email);
			}
		}
		return duplicateEmails;
	}

	static class User {
		private String email;
		private String nickname;

		public User(List<String> form) {
			this.email = form.get(0);
			this.nickname = form.get(1);
		}

		public Collection<String> getDuplicateNicknameTokens() {
			Set<String> duplicateTokens = new HashSet<>();
			for (int i = 1; i < nickname.length(); i++) {
				int ptr1 = 0;
				int ptr2 = i + 1;
				while (ptr2 <= nickname.length()) {
					duplicateTokens.add(nickname.substring(ptr1, ptr2));
					ptr1++;
					ptr2++;
				}
			}
			return duplicateTokens;
		}

		public boolean checkDuplicate(String token) {
			return nickname.contains(token);
		}
	}
}
