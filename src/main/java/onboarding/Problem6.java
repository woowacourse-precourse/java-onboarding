package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {

		List<String> selectedList = new ArrayList<>();

		for (int i = 0; i < forms.size(); i++) {

			List<String> elementByTwoDimension = forms.get(i);

			for (int j = 0; j < forms.size(); j++) {
				if (j == i) {
					// do nothing
				} else {
					List<String> ElementByOneDimension = forms.get(j);

					String setName = elementByTwoDimension.get(1);
					String setEmail = elementByTwoDimension.get(0);
					String compareName = ElementByOneDimension.get(1);


					if (checkConsecutiveCharacter(setName, compareName)) {
						selectedList.add(setEmail);
					}
				}
			}
		}

		List<String> answer = removeDuplication(selectedList);
		answer.sort(Comparator.naturalOrder());

		return answer;
	}

	private static List<String> removeDuplication(List<String> selectedList) {
		List<String> answer;
		answer = selectedList.stream().distinct().collect(Collectors.toList());
		return answer;
	}

	private static boolean checkConsecutiveCharacter(String setName, String compareName) {

		for (int i = 0; i < setName.length() - 1; i++) {
			String sub = setName.substring(i, i + 2);

			if (compareName.contains(sub)) { return  true; }

		}

		return false;
	}
}
