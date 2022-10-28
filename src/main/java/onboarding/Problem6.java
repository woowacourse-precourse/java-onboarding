package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");
		return answer;
	}

	static class NicknameFilter {

		private static final String EMAIL_FORM = "@email.com";

		private final HashMap<String, String> userMap;
		private final HashSet<String> nicknamePatternSet;

		NicknameFilter() {
			this.userMap = new HashMap<>();
			this.nicknamePatternSet = new HashSet<>();
		}

		private void initUserInfo(List<String> forms) {
			String email = forms.get(0);
			email = emailParser(email);
			String nickname = forms.get(1);

			nicknamePatternCreator(nickname);

			userMap.put(nickname, email);
		}

		private void nicknamePatternCreator(String nickname) {
			String[] split = nickname.split("");
			int i = 0;

			while (true) {
				nicknamePatternSet.add(split[i] + split[i + 1]);
				if (i == split.length - 2) {
					break;
				}
				i++;
			}
		}

		private String emailParser(String email) {
			return email.replaceAll(EMAIL_FORM, "");
		}
	}
}
