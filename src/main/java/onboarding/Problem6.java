package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		Map<String, Set<String>> nicknameSetMap = mapByNicknameMapSet(forms);
		Set<String> emailSet = new HashSet<>();

		for (List<String> form : forms) {
			if (!isValidSize(forms.size())) {
				return Collections.emptyList();
			}

			if (!isEmailFormat(form.get(0)) || !isValidEmailLength(form.get(0).length())) {
				return Collections.emptyList();
			}

			String nickname = form.get(1);
			for (int i = 0; i < nickname.length() - 1; i++) {
				Set<String> nicknameSet = nicknameSetMap.get(nickname.substring(i, i + 2));
				if (nicknameSet.size() > 1) {
					emailSet.add(form.get(0));
				}
			}
		}

		List<String> answer = emailSet.stream().sorted().collect(Collectors.toList());
		return answer;
	}

	private static boolean isValidSize(int size) {
		return size >= 1 && size <= 1000000;
	}

	private static boolean isValidEmailLength(int length) {
		return length >= 1 && length <= 20;
	}

	private static boolean isEmailFormat(String email) {
		int searchIdx = email.indexOf('@');
		String format = email.substring(searchIdx + 1);
		return format.equals("email.com");
	}

	public static Map<String, Set<String>> mapByNicknameMapSet(List<List<String>> forms) {
		Map<String, Set<String>> nicknameSetMap = new HashMap<>();

		for (List<String> form : forms) {
			String nickname = form.get(1);
			for (int i = 0; i < nickname.length() - 1; i++) {
				Set<String> nicknameSet = nicknameSetMap.getOrDefault(nickname.substring(i, i + 2), new HashSet<>());
				nicknameSet.add(nickname);
				nicknameSetMap.put(nickname.substring(i, i + 2), nicknameSet);
			}
		}

		return nicknameSetMap;
	}
}
