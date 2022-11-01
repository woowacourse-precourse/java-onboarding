package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		check1(forms);
		check2(forms);
		check3(forms);
		List<String> answer = new ArrayList<>();
		Map<String, String> map = new HashMap<>();

		for (List<String> list : forms) {
			String email = list.get(0);
			String id = list.get(1);
			for (int i = 0; i < id.length() - 1; i++) {
				String key = id.substring(i, i + 2);
				if (map.containsKey(key)) {
					answer.add(email);
					if (!answer.contains(map.get(key))) {
						answer.add(map.get(key));
					}
					break;
				}
				map.put(key, email);

			}
		}
		Collections.sort(answer);

		return answer;
	}

	public static void check1(List<List<String>> forms) throws IllegalArgumentException {
		if (forms.size() < 1 || forms.size() > 10000) {
			throw new IllegalArgumentException("크루명이 1 미만이거나 10000 초과입니다.");
		}

	}
	public static void check2(List<List<String>> forms) throws IllegalArgumentException {
		for (List<String> list : forms) {
			String email = list.get(0);
			if (email.length() < 11 || email.length() >= 20) {
				throw new IllegalArgumentException("이메일 길이가 11자 미만 20자 이상입니다.");
			}
		}
	}
	public static void check3(List<List<String>> forms) throws IllegalArgumentException {
		String pattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@email.com";
		for (List<String> list : forms) {
			String email = list.get(0);
			if (!Pattern.matches(pattern, email)) {
				throw new IllegalArgumentException("이메일 형식이 맞지 않습니다.");
			}
		}
	}
}
