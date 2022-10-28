package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		// NicknameFilter nicknameFilter = new NicknameFilter();
		// return nicknameFilter.filter(forms);
		return null;
	}

	static class NicknameFilter {

		private static final String EMAIL_FORM = "@email.com";

		private final HashMap<String, String> userMap;

		NicknameFilter() {
			this.userMap = new HashMap<>();
		}

		private boolean isDuplicatedPattern(String nickname, HashSet<String> nicknamePattern) {
			String[] split = nickname.split("");
			int i = 0;
			while (true) {
				String pattern = split[i] + split[i + 1];

				if (nicknamePattern.contains(pattern)) {
					return true;
				}
				if (i == split.length - 2) {
					return false;
				}
				i++;
			}
		}

		private void initUserInfo(List<String> forms) {
			String email = forms.get(0);
			email = emailParser(email);
			String nickname = forms.get(1);

			userMap.put(nickname, email);
		}

		private HashSet<String> nicknamePatternCreator(String nickname) {
			String[] split = nickname.split("");

			HashSet<String> nicknamePattern = new HashSet<>();
			int i = 0;

			while (true) {
				nicknamePattern.add(split[i] + split[i + 1]);
				if (i == split.length - 2) {
					break;
				}
				i++;
			}
			return nicknamePattern;
		}

		private String emailParser(String email) {
			return email.replaceAll(EMAIL_FORM, "");
		}
	}
}
