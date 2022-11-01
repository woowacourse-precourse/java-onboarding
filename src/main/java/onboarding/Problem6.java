package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {

	private static final String VALID_DOMAIN = "@email.com";

	public static List<String> solution(List<List<String>> forms) {

		List<String> answer = Collections.emptyList();

		try {
			isValidForms(forms);
		} catch (IllegalStateException formErrorExceptions) {
			formErrorExceptions.printStackTrace();
			return answer;
		}

		answer = getResultList(forms);

		return answer;
	}

	public static void isValidForms(List<List<String>> forms) throws IllegalStateException {
		if (forms.size() < 1 || forms.size() > 10000)
			throw new IllegalStateException("크루원의 숫자가 올바르지 않습니다.");
		if (!forms.stream().allMatch(form -> isValidEmailLength(form.get(0))))
			throw new IllegalStateException("크루원의 이메일의 길이가 올바르지 않습니다");
		if (!forms.stream().allMatch(form -> isValidEmailDomain(form.get(0))))
			throw new IllegalStateException("크루원의 이메일 도메인이 올바르지 않습니다.");
		if (forms.stream().anyMatch(form -> isNicknameContainsEnglish(form.get(1))))
			throw new IllegalStateException("크루원의 닉네임에 영어가 포함되어있습니다.");
		if (forms.stream().allMatch(form -> isValidNicknameLength(form.get(1))))
			throw new IllegalStateException("크루원의 닉네임의 길이가 올바르지 않습니다.");
	}

	public static boolean isValidEmailLength(String email) {
		if (email.length() >= 11 && email.length() <= 19)
			return true;
		return false;
	}

	public static boolean isValidEmailDomain(String email) {
		if (email.contains(VALID_DOMAIN))
			return true;
		return false;
	}

	public static boolean isNicknameContainsEnglish(String nickname) {
		if (nickname.chars().anyMatch(Character::isAlphabetic))
			return true;
		return false;
	}

	public static boolean isValidNicknameLength(String nickname) {
		if (nickname.length() > 0 && nickname.length() < 20)
			return true;
		return false;
	}

	public static List<String> getSameNicknameList(List<List<String>> forms) {
		Map<String, String> nicknameMap = new HashMap<>();
		List<String> sameNicknameList = new ArrayList<>();

		forms.forEach(form -> {
			getNicknameCombinations(form).forEach(combination -> {
				if (nicknameMap.containsKey(combination)) {
					sameNicknameList.add(form.get(0));
					sameNicknameList.add(nicknameMap.get(combination));
				} else {
					nicknameMap.put(combination, form.get(0));
				}
			});
		});

		return sameNicknameList;
	}

	public static List<String> getNicknameCombinations(List<String> form) {
		List<String> combinations = new ArrayList<>();
		StringBuilder combination;

		for (int i = 0; i < form.get(1).length() - 1; i++) {
			combination = new StringBuilder();
			combination.append(form.get(1).charAt(i)).append(form.get(1).charAt(i + 1));
			combinations.add(combination.toString());
		}

		return combinations;
	}

	public static List<String> getResultList(List<List<String>> forms) {
		return getSameNicknameList(forms).stream().distinct().sorted().collect(Collectors.toList());
	}
}
