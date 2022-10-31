package onboarding.problem6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class NicknameFilter {

	private static final String EMAIL_FORM = "@email.com";

	private final HashMap<String, String> userMap;

	public NicknameFilter() {
		this.userMap = new HashMap<>();
	}

	public List<String> filter(List<List<String>> forms) {
		initUserInfo(forms);

		HashSet<String> filteredUserSet = new HashSet<>();

		for (int i = 0; i < forms.size(); i++) {

			String targetNickname = forms.get(i).get(1);
			HashSet<String> nicknamePattern = nicknamePatternCreator(targetNickname);

			for (int j = 0; j < forms.size(); j++) {
				if (i == j) {
					continue;
				}
				String nickname = forms.get(j).get(1);
				if (isDuplicatedPattern(nickname, nicknamePattern)) {
					filteredUserSet.add(userMap.get(nickname));
				}
			}
		}
		return filteredUserSet
				.stream()
				.sorted()
				.map(email -> email + EMAIL_FORM)
				.collect(Collectors.toList());
	}

	private boolean isDuplicatedPattern(String nickname, HashSet<String> nicknamePattern) {
		for (String pattern : nicknamePattern) {
			if (nickname.contains(pattern)) {
				return true;
			}
		}
		return false;
	}

	private void initUserInfo(List<List<String>> forms) {
		for (List<String> form : forms) {
			String email = form.get(0);
			String nickname = form.get(1);

			email = emailParser(email);

			userMap.put(nickname, email);
		}
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
