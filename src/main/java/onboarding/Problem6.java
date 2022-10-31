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
		Map<String, String> dict = new HashMap<>();
		List<String> nicknameList = new ArrayList<>(); // 각 크루의 닉네임을 두 글자씩 쪼개어 담을 리스트
		Set<String> duplSet = new HashSet<>(); // 중복된 닉네임 set

		// HashMap 초기화
		for (List<String> form : forms) {
			dict.put(form.get(0), form.get(1));
		}

		// 두 글자씩 쪼개어 리스트에 추가
		for (String value : dict.values()) {
			char[] charArr = value.toCharArray();
			for (int i = 0; i < charArr.length - 1; i++) {
				nicknameList.add(Character.toString(charArr[i]) + charArr[i + 1]);
			}
		}

		// 두 글자씩 쪼갠 리스트에서 중복을 찾아 set 에 추가
		for (String str : nicknameList) {
			if (nicknameList.indexOf(str) != nicknameList.lastIndexOf(str)) {
				duplSet.add(str);
			}
		}

		// 크루의 닉네임 안에 duplSet 의 요소가 포함되어 있으면 닉네임 사용 제한
		for (Map.Entry<String, String> entry : dict.entrySet()) {
			for (String s : duplSet) {
				if (entry.getValue().contains(s)) {
					answer.add(entry.getKey());
				}
			}
		}

		return answer;
	}
}
