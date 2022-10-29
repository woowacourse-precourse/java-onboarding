package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<>();
		List<String> nicknames = collectNicknames(forms);

		for (List info : forms) {
			String email = (String)info.get(0);
			String nickname = (String)info.get(1);
			nicknames.remove(nickname);
			if (checkNickname(nickname, nicknames)) {
				answer.add(email);
			}
			nicknames.add(nickname);

		}
		Collections.sort(answer);

		return answer;
	}

	private static List collectNicknames(List<List<String>> data) {
		List<String> collection = new ArrayList<>();
		for (List target : data) {
			collection.add((String)target.get(1));
		}
		return collection;
	}

	private static boolean checkNickname(String name, List<String> comparedNames) {

		for (String target : comparedNames) {
			for (int i = 0; i < name.length() - 1; i++) {
				if (target.contains(name.substring(i, i + 2))) {
					return true;
				}
			}
		}
		return false;
	}
}
