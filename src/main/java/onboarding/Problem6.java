package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
	static Set<String> duplicateEmailSet;
	static HashMap<String, String> duplicateMap;

	public static List<String> solution(List<List<String>> forms) {
		duplicateEmailSet = new HashSet<>();
		duplicateMap = new HashMap<>();
		List<String> answer;
		String email;
		String nickName;

		for (List<String> member : forms) {
			email = member.get(0);
			nickName = member.get(1);
			checkDuplicate(nickName, email);
		}
		answer = new ArrayList<>(duplicateEmailSet);
		answer.sort(Comparator.naturalOrder());

		return answer;
	}

	public static void checkDuplicate(String nickName, String email) {
		String twoLetters;
		for (int i = 0; i < nickName.length() - 1; i++) {
			twoLetters = nickName.substring(i, i + 2);
			if (duplicateMap.containsKey(twoLetters)) {
				if (duplicateMap.get(twoLetters).equals(email)) {
					continue;
				}
				duplicateEmailSet.add(email);
				duplicateEmailSet.add(duplicateMap.get(twoLetters));
				continue;
			}
			duplicateMap.put(twoLetters, email);
		}
	}
}
