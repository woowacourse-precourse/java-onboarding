package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

	public static final int EMAIL = 0;
	public static final int NICKNAME = 1;
	public static final int SPLIT_UNIT = 2;

	public static final int EXCEPTION = -1;

	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<>();
		Map<String, String> emailAndNicknames;
		List<String> splitNicknames; // 각 크루의 닉네임을 두 글자씩 쪼개어 담을 리스트
		Set<String> duplicateNicknames; // 중복된 닉네임 set

		if (checkRestrictions(forms) == EXCEPTION) {
			return answer;
		}

		emailAndNicknames = initMapWithEmailAndNicknames(forms);
		splitNicknames = initSplitNicknames(emailAndNicknames);
		duplicateNicknames = initDuplicateNicknames(splitNicknames);
		answer = getCrewUsingInvalidNickname(emailAndNicknames, duplicateNicknames);
		Collections.sort(answer);

		return answer;
	}

	/**
	 * 크루들의 이메일과 닉네임으로 map 을 초기화하는 메서드
	 * @param forms
	 */
	private static Map<String, String> initMapWithEmailAndNicknames(List<List<String>> forms) {
		Map<String, String> emailAndNicknames = new HashMap<>();
		for (List<String> form : forms) {
			emailAndNicknames.put(form.get(EMAIL), form.get(NICKNAME));
		}
		return emailAndNicknames;
	}

	/**
	 * 사용이 제한되는 닉네임을 사용하는 크루들을 반환하는 메서드
	 * (크루의 닉네임 안에 duplicateNicknames 의 요소가 포함되어 있으면 사용이 제한되는 닉네임이다.)
	 * @param emailAndNicknames
	 * @param duplicateNicknames
	 */
	private static List<String> getCrewUsingInvalidNickname(Map<String, String> emailAndNicknames,
		Set<String> duplicateNicknames) {
		Set<String> answer = new HashSet<>();
		String nickname;
		String email;
		for (Map.Entry<String, String> entry : emailAndNicknames.entrySet()) {
			nickname = entry.getValue();
			for (String duplicateNickname : duplicateNicknames) {
				if (nickname.contains(duplicateNickname)) {
					email = entry.getKey();
					answer.add(email);
				}
			}
		}
		return new ArrayList<>(answer);
	}

	/**
	 * splitNicknames 트에서 중복을 찾아 duplicateNicknames 에 추가하는 메서드
	 * @param splitNicknames
	 */
	private static Set<String> initDuplicateNicknames(List<String> splitNicknames) {
		Set<String> duplicateNicknames = new HashSet<>();
		for (String splitNickname : splitNicknames) {
			if (splitNicknames.indexOf(splitNickname) != splitNicknames.lastIndexOf(splitNickname)) {
				duplicateNicknames.add(splitNickname);
			}
		}
		return duplicateNicknames;
	}

	/**
	 * 닉네임을 두 글자씩 쪼개어 splitNicknames 에 추가하는 메서드
	 * @param emailAndNicknames
	 */
	private static List<String> initSplitNicknames(Map<String, String> emailAndNicknames) {
		List<String> splitNicknames = new ArrayList<>();
		for (String nickname : emailAndNicknames.values()) {
			for (int i = 0; i < nickname.length() - 1; i++) {
				splitNicknames.add(nickname.substring(i, i + SPLIT_UNIT));
			}
		}
		return splitNicknames;
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
		if (!isNicknameRangeValid(forms)) {
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
			if (form.get(EMAIL).length() < 11 || form.get(EMAIL).length() >= 20) {
				return false;
			}
		}
		return true;
	}

	// 닉네임의 전체 길이가 1자 이상 20자 미만이 아닌 경우 예외
	private static boolean isNicknameRangeValid(List<List<String>> forms) {
		for (List<String> form : forms) {
			if (form.get(NICKNAME).length() < 1 || form.get(NICKNAME).length() >= 20) {
				return false;
			}
		}
		return true;
	}
}
