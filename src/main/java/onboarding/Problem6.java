package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {
	static List<String> answer = List.of("answer");
	static HashMap<String, String> duplicateMap = new HashMap<>();

	@SuppressWarnings("checkstyle:WhitespaceAround")
	public static void checkDuplicate(String nickName, String email) {
		String twoLetters;
		for (int i = 0; i < nickName.length() - 1; i++) {
			twoLetters = nickName.substring(i, i + 2);
			if (duplicateMap.containsKey(twoLetters)) {
				if (duplicateMap.get(twoLetters).equals(email)) {
					continue;
				}
				answer.add(email);
				continue;
			}
			duplicateMap.put(twoLetters, email);
		}
	}

	public static List<String> solution(List<List<String>> forms) {
		String email;
		String nickName;
		int index = 0;
		for (List<String> member : forms) {
			email = member.get(0);
			nickName = member.get(1);
			checkDuplicate(nickName, email);
		}
		return answer;
	}
}
