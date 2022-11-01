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
		List<String> splitNicknamesIntoTwoDigit; // 각 크루의 닉네임을 두 글자씩 쪼개어 담을 리스트
		Set<String> duplicateNicknames; // 중복된 닉네임 set

		if (checkRestrictions(forms) == EXCEPTION) {
			return answer;
		}

		emailAndNicknames = initMapWithEmailAndNicknames(forms);
		splitNicknamesIntoTwoDigit = initSplitNicknames(emailAndNicknames);
		duplicateNicknames = initDuplicateNicknames(splitNicknamesIntoTwoDigit);
		answer = getCrewUsingInvalidNickname(emailAndNicknames, duplicateNicknames);
		Collections.sort(answer);

		return answer;
	}

	private static Map<String, String> initMapWithEmailAndNicknames(List<List<String>> forms) {
		Map<String, String> emailAndNicknames = new HashMap<>();
		for (List<String> form : forms) {
			emailAndNicknames.put(form.get(EMAIL), form.get(NICKNAME));
		}
		return emailAndNicknames;
	}

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

	private static Set<String> initDuplicateNicknames(List<String> splitNicknamesIntoTwoDigit) {
		Set<String> duplicateNicknames = new HashSet<>();
		for (String splitNickname : splitNicknamesIntoTwoDigit) {
			if (splitNicknamesIntoTwoDigit.indexOf(splitNickname) != splitNicknamesIntoTwoDigit.lastIndexOf(
				splitNickname)) {
				duplicateNicknames.add(splitNickname);
			}
		}
		return duplicateNicknames;
	}

	private static List<String> initSplitNicknamesIntoTwoDigit(Map<String, String> emailAndNicknames) {
		List<String> splitNicknamesIntoTwoDigit = new ArrayList<>();
		for (String nickname : emailAndNicknames.values()) {
			for (int i = 0; i < nickname.length() - 1; i++) {
				splitNicknamesIntoTwoDigit.add(nickname.substring(i, i + SPLIT_UNIT));
			}
		}
		return splitNicknamesIntoTwoDigit;
	}

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

	private static boolean isCrewRangeValid(List<List<String>> forms) {
		if (forms.size() < 1 || forms.size() > 10000) {
			return false;
		}
		return true;
	}

	private static boolean isEmailRangeValid(List<List<String>> forms) {
		for (List<String> form : forms) {
			if (form.get(EMAIL).length() < 11 || form.get(EMAIL).length() >= 20) {
				return false;
			}
		}
		return true;
	}

	private static boolean isNicknameRangeValid(List<List<String>> forms) {
		for (List<String> form : forms) {
			if (form.get(NICKNAME).length() < 1 || form.get(NICKNAME).length() >= 20) {
				return false;
			}
		}
		return true;
	}
}
