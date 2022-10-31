package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
	private static final int MIN_SAME_LENGTH = 2;

	public static List<String> solution(List<List<String>> forms) {
		List<String> answer;
		Map<String, Integer> twoWordNickNames = makeSubStrings(forms);
		Set<String> warnEmail = makeWarnEmails(forms, twoWordNickNames);

		answer = new ArrayList<>(warnEmail);
		Collections.sort(answer);

		return answer;
	}

	private static HashMap<String, Integer> makeSubStrings(List<List<String>> forms) {
		HashMap<String, Integer> subStrings = new HashMap<>();
		for (List<String> form : forms) {
			String nickName = form.get(1);
			for (int j = 0; j < nickName.length() - 1; j++) {
				String twoWord = nickName.substring(j, j + MIN_SAME_LENGTH);
				subStrings.put(twoWord, subStrings.getOrDefault(twoWord, 0) + 1);
			}
		}
		return subStrings;
	}

	private static HashSet<String> makeWarnEmails(List<List<String>> forms, Map<String, Integer> nickNameMap) {
		HashSet<String> warnEmails = new HashSet<>();
		for (List<String> form : forms) {
			String email = form.get(0);
			String nickName = form.get(1);
			for (int j = 0; j < nickName.length() - 1; j++) {
				String twoWord = nickName.substring(j, j + MIN_SAME_LENGTH);
				if (nickNameMap.get(twoWord) > 1) {
					warnEmails.add(email);
					break;
				}
			}
		}
		return warnEmails;
	}
}
