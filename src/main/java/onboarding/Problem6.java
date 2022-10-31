package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

	private static class Crew {
		private final static int EMAIL_INDEX = 0;
		private final static int NICKNAME_INDEX = 1;
		private final String email;
		private final String nickname;

		private Crew(List<String> form) {
			this.email = form.get(EMAIL_INDEX);
			this.nickname = form.get(NICKNAME_INDEX);
		}
	}
}
