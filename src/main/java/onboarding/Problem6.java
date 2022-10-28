package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<User> userList = forms.stream()
				.map(User::new)
				.collect(Collectors.toList());

		return Collections.emptyList();
	}

	static class User {
		private String email;
		private String nickname;

		public User(List<String> form) {
			this.email = form.get(0);
			this.nickname = form.get(1);
		}
	}
}
