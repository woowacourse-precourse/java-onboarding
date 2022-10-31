package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		List<String> splitNicknames = new ArrayList<>(); // 각 크루의 닉네임을 두 글자씩 쪼개어 담을 리스트
		Set<String> duplicateNicknames = new HashSet<>(); // 중복된 닉네임 set
		char[] nicknameArr;
		String email;

		// HashMap 초기화
		for (List<String> form : forms) {
			map.put(form.get(0), form.get(1));
		}

		// 두 글자씩 쪼개어 splitNicknames 에 추가
		for (String nickname : map.values()) {
			nicknameArr = nickname.toCharArray();
			for (int i = 0; i < nicknameArr.length - 1; i++) {
				splitNicknames.add(Character.toString(nicknameArr[i]) + nicknameArr[i + 1]);
			}
		}

		// 두 글자씩 쪼갠 리스트에서 중복을 찾아 duplicateNicknames 에 추가
		for (String splitNickname : splitNicknames) {
			if (splitNicknames.indexOf(splitNickname) != splitNicknames.lastIndexOf(splitNickname)) {
				duplicateNicknames.add(splitNickname);
			}
		}

		// 크루의 닉네임 안에 duplicateNicknames 의 요소가 포함되어 있으면 닉네임 사용 제한
		for (Map.Entry<String, String> entry : map.entrySet()) {
			for (String duplicateNickname : duplicateNicknames) {
				if (entry.getValue().contains(duplicateNickname)) {
					email = entry.getKey();
					answer.add(email);
				}
			}
		}

		return answer;
	}
}
