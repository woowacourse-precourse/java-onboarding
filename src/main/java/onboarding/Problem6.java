package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
	private static final int EMAIL_INDEX = 0;
	private static final int NAME_INDEX = 1;

	public static List<String> solution(List<List<String>> forms) {
		Map<String, Integer> duplicatedNameCount = checkDuplicatedNameCount(forms);
		List<String> limitList = makeDuplicateEmailList(forms, duplicatedNameCount);
		return makeResultForm(limitList);
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
