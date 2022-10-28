package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		Set<String> blacklist = new HashSet<>();
		List<User> userList = forms.stream()
				.map(User::new)
				.collect(Collectors.toList());

		for (User user : userList) {
			blacklist.addAll(user.getDuplicateNicknameTokens());
		}
		System.out.println(blacklist);

		return Collections.emptyList();
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
	}
}
