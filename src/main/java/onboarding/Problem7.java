package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

	private static class User {
		private final String name;
		private final List<User> friendList = new ArrayList<>();

		public User(String name) {
			this.name = name;
		}

	}
}
