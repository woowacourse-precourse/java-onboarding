package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {

		List<String> selectedList = new ArrayList<>();

		for (int i = 0; i < forms.size(); i++) {
			checkElementAtOneDimensionalLevel(forms, selectedList, i);
		}

		List<String> answer = removeDuplication(selectedList);
		answer.sort(Comparator.naturalOrder());

		return answer;
	}

	private static void checkElementAtOneDimensionalLevel(List<List<String>> forms, List<String> selectedList, int i) {
		List<String> elementByTwoDimension = forms.get(i);

		for (int j = 0; j < forms.size(); j++) {

			if (j != i) {
				List<String> ElementByOneDimension = forms.get(j);
				addSelectedToList(selectedList, elementByTwoDimension, ElementByOneDimension);
			}

		}
	}

	private static void addSelectedToList(List<String> selectedList, List<String> elementByTwoDimension, List<String> ElementByOneDimension) {
		String setName = elementByTwoDimension.get(1);
		String setEmail = elementByTwoDimension.get(0);
		String compareName = ElementByOneDimension.get(1);

		if (checkConsecutiveCharacter(setName, compareName)) {
			selectedList.add(setEmail);
		}

	}

	private static List<String> removeDuplication(List<String> selectedList) {
		List<String> answer;
		answer = selectedList.stream().distinct().collect(Collectors.toList());
		return answer;
	}

	private static boolean checkConsecutiveCharacter(String setName, String compareName) {

		for (int i = 0; i < setName.length() - 1; i++) {
			String sub = setName.substring(i, i + 2);

			if (compareName.contains(sub)) {
				return true;
			}

		}

		return false;
	}
}
