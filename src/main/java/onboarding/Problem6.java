package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
	private static final String DOMAIN = "@email.com";

	public static boolean isValidInput(String email, String nickName) {
		if (11 > email.length() || email.length() >= 20) {
			return false;
		} else if (1 > nickName.length() || nickName.length() >= 20) {
			return false;
		} else if (!email.endsWith(DOMAIN)) {
			return false;
		}
		return true;
	}

	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<>();
		Map<String, Integer> twoWordNickNames = new HashMap<>();
		Set<String> warnEmail = new HashSet<>();

		for (int i = 0; i < forms.size(); i++) {
			if (!isValidInput(forms.get(i).get(0), forms.get(i).get(1))) {
				continue;
			}
			String nickName = forms.get(i).get(1);
			for (int j = 0; j < nickName.length() - 1; j++) {
				String twoWord = nickName.substring(j, j + 2);
				twoWordNickNames.put(twoWord, twoWordNickNames.getOrDefault(twoWord, 0) + 1);
			}
		}
		for (int i = 0; i < forms.size(); i++) {
			if (!isValidInput(forms.get(i).get(0), forms.get(i).get(1))) {
				continue;
			}
			String nickName = forms.get(i).get(1);
			for (int j = 0; j < nickName.length() - 1; j++) {
				String twoWord = nickName.substring(j, j + 2);
				if (twoWordNickNames.get(twoWord) > 1) {
					warnEmail.add(forms.get(i).get(0));
					break;
				}
			}
		}
		answer = new ArrayList<>(warnEmail);
		Collections.sort(answer);
		return answer;
	}
}
