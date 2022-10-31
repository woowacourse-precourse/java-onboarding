package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
	private static final int EMAIL = 0;
	private static final int NAME = 1;
	private static final int INITIAL_COUNT = 0;

	public static List<String> solution(List<List<String>> forms) {
		Map<String, Integer> twoLettersMap = createTwoLettersCombination(forms);
		Set<String> emailsNeedNotify = createEmailsNeedNotify(forms, twoLettersMap);

		return new ArrayList<>(emailsNeedNotify);
	}

	private static Map<String, Integer> createTwoLettersCombination(List<List<String>> forms) {
		Map<String, Integer> twoLettersCombination = new HashMap<>();

		for (List<String> form : forms) {
			String name = form.get(NAME);

			for (int start = 0; start < name.length() - 1; start++) {
				String twoLetters = name.substring(start, start + 2);

				twoLettersCombination.put(twoLetters,
					twoLettersCombination.getOrDefault(twoLetters, INITIAL_COUNT) + 1);
			}
		}
		return twoLettersCombination;
	}

	private static Set<String> createEmailsNeedNotify(List<List<String>> forms,
		Map<String, Integer> twoLettersCombination) {
		Set<String> duplicateNameSet = new TreeSet<>();

		for (List<String> form : forms) {
			String name = form.get(NAME);
			String email = form.get(EMAIL);

			for (int i = 0; i < name.length() - 1; i++) {
				String twoLetters = name.substring(i, i + 2);

				if (isDuplicateNameExist(twoLettersCombination, twoLetters) && duplicateNameSet.add(email)) {
					break;
				}
			}
		}
		return duplicateNameSet;
	}

	private static boolean isDuplicateNameExist(Map<String, Integer> twoLettersCombination, String twoLetters) {
		return twoLettersCombination.get(twoLetters) > 1;
	}
}
