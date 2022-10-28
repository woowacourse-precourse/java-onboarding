package onboarding;

import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {

		for (List<String> form : forms) {
			String nickname = form.get(1);
			if (nickname.length() < 2) {
				continue;
			}
		}

		List<String> answer = List.of("answer");
		return answer;
	}
}
