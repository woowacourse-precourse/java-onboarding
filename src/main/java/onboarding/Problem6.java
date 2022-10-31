package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
	private static final int EMAIL_INDEX = 0;
	private static final int NAME_INDEX = 1;
	private static final int MIN_CREW_COUNT = 1;
	private static final int MAX_CREW_COUNT = 10000;
	private static final int MIN_EMAIL_LENGTH = 11;
	private static final int MAX_EMAIL_LENGTH = 19;
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 19;
	private static final String POSSIBLE_DOMAIN = "email.com";
	private static final String NAME_REGEX = "^[가-힣]*$";

	public static List<String> solution(List<List<String>> forms) {
		if (!checkInputForm(forms)) {
			throw new IllegalArgumentException();
		}
		Map<String, Integer> duplicatedNameCount = checkDuplicatedNameCount(forms);
		List<String> limitList = makeDuplicateEmailList(forms, duplicatedNameCount);
		return makeResultForm(limitList);
	}

	private static boolean checkInputForm(List<List<String>> forms) {
		return checkLimitCrewCount(forms) && checkEmailLength(forms) && checkEmailDomain(forms)
			&& checkNameForm(forms) && checkNameLength(forms);
	}

	private static boolean checkLimitCrewCount(List<List<String>> forms) {
		return forms.size() >= MIN_CREW_COUNT && forms.size() <= MAX_CREW_COUNT;
	}

	private static boolean checkEmailLength(List<List<String>> forms) {
		return forms.stream()
			.allMatch(form -> form.get(EMAIL_INDEX).length() >= MIN_EMAIL_LENGTH
				&& form.get(EMAIL_INDEX).length() <= MAX_EMAIL_LENGTH);
	}

	private static boolean checkEmailDomain(List<List<String>> forms) {
		return forms.stream()
			.allMatch(form -> form.get(EMAIL_INDEX).contains(POSSIBLE_DOMAIN));
	}

	private static boolean checkNameForm(List<List<String>> forms) {
		return forms.stream()
			.allMatch(form -> form.get(NAME_INDEX).matches(NAME_REGEX));
	}

	private static boolean checkNameLength(List<List<String>> forms) {
		return forms.stream()
			.allMatch(form -> form.get(NAME_INDEX).length() >= MIN_NAME_LENGTH
				&& form.get(NAME_INDEX).length() <= MAX_NAME_LENGTH);
	}

	private static Map<String, Integer> checkDuplicatedNameCount(List<List<String>> forms) {
		Map<String, Integer> duplicatedName = new HashMap<>();
		for (List<String> form : forms) {
			for (int i = 0; i < form.get(NAME_INDEX).length() - 1; i++) {
				String twoLengthName = form.get(NAME_INDEX).substring(i, i + 2);
				duplicatedName.put(twoLengthName,
					duplicatedName.getOrDefault(twoLengthName, 0) + 1);
			}
		}
		return duplicatedName;
	}

	private static List<String> makeDuplicateEmailList(List<List<String>> forms,
		Map<String, Integer> duplicatedNameList) {
		List<String> resultList = new ArrayList<>();
		for (List<String> form : forms) {
			for (int i = 0; i < form.get(NAME_INDEX).length() - 1; i++) {
				String twoLengthName = form.get(NAME_INDEX).substring(i, i + 2);
				if (duplicatedNameList.get(twoLengthName) > 1) {
					resultList.add(form.get(EMAIL_INDEX));
					break;
				}
			}
		}
		return resultList;
	}

	private static List<String> makeResultForm(List<String> resultList) {
		return resultList.stream()
			.distinct()
			.sorted()
			.collect(Collectors.toList());
	}
}
