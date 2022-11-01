package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

	public static final int EXCEPTION = -1;

	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		List<String> splitNicknames = new ArrayList<>(); // 각 크루의 닉네임을 두 글자씩 쪼개어 담을 리스트
		Set<String> duplicateNicknames = new HashSet<>(); // 중복된 닉네임 set
		char[] nicknameArr;
		String email;

		if (checkRestrictions(forms) == EXCEPTION) {
			return answer;
		}

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

	/**
	 * 제한사항을 위배했는지 체크하는 메서드
	 * @param forms
	 * @return
	 */
	private static Integer checkRestrictions(List<List<String>> forms) {
		if (!isCrewRangeValid(forms)) {
			return EXCEPTION;
		}
		if (!isEmailRangeValid(forms)) {
			return EXCEPTION;
		}
		return 0;
	}

	// 크루의 수가 1명 이상 10,000명 이하가 아닌 경우 예외
	private static boolean isCrewRangeValid(List<List<String>> forms) {
		if (forms.size() < 1 || forms.size() > 10000) {
			return false;
		}
		return true;
	}

	// 이메일의 전체 길이가 11자 이상 20자 미만이 아닌 경우 예외
	private static boolean isEmailRangeValid(List<List<String>> forms) {
		for (List<String> form : forms) {
			if (form.get(0).length() < 11 || form.get(0).length() >= 20) {
				return false;
			}
		}
		return true;
	}
}
