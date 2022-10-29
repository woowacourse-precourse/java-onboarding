package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer;
		Map<String, Integer> twoWordNickNames = new HashMap<>();
		Set<String> warnEmail = new HashSet<>();

		for (List<String> form : forms) {
			String nickName = form.get(1);
			for (int j = 0; j < nickName.length() - 1; j++) {
				String twoWord = nickName.substring(j, j + 2);
				twoWordNickNames.put(twoWord, twoWordNickNames.getOrDefault(twoWord, 0) + 1);
			}
		}
		for (List<String> form : forms) {
			String email = form.get(0);
			String nickName = form.get(1);
			for (int j = 0; j < nickName.length() - 1; j++) {
				String twoWord = nickName.substring(j, j + 2);
				if (twoWordNickNames.get(twoWord) > 1) {
					warnEmail.add(email);
					break;
				}
			}
		}
		answer = new ArrayList<>(warnEmail);
		Collections.sort(answer);
		return answer;
	}
}
