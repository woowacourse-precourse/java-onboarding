package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
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
