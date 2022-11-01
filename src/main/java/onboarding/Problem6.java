package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		checkList(forms);
		List<String> answer = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (List<String> list : forms) {
			String id = list.get(1);
			for (int i = 0; i < id.length() - 1; i++) {
				String piece = id.substring(i, i + 2);
				map.put(piece, map.getOrDefault(piece, 0) + 1);
			}
		}
		for (List<String> list : forms) {
			String email = list.get(0), id = list.get(1);
			for (int i = 0; i < id.length() - 1; i++) {
				String piece = id.substring(i, i + 2);
				if (map.get(piece) >= 2 && !answer.contains(email)) {
					answer.add(email);
					break;
				}
			}
		}
		Collections.sort(answer);
		return answer;
	}

	public static void checkList(List<List<String>> forms) throws IllegalArgumentException {
		if (forms.size() < 1 || forms.size() > 10000) {
			throw new IllegalArgumentException("크루가 1명 미만 또는 100000명 초과되었습니다.");
		}
		for (List<String> list : forms) {
			String email = list.get(0), name = list.get(1);
			if (email.length() < 11 || email.length() > 20) {
				throw new IllegalArgumentException("email의 길이가 맞지 않습니다.");
			}
			if (!email.substring(email.length() - 10).equals("@email.com")) {
				throw new IllegalArgumentException("\"@email.com\"도메인이 아닙니다.");
			}
			if (!name.matches("^[가-힣]*$")) {
				throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
			}
			if (name.length() < 1 || name.length() >= 20) {
				throw new IllegalArgumentException("닉네임의 길이가 부합하지 않습니다.");
			}
		}
	}
}