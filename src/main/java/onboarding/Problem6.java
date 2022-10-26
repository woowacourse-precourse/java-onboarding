package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
	private final static String DOMAINTYPE = "@email.com";
	private static HashMap<String, Integer> UsedList;
	private static boolean[] isRepeat;

	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<>();
		UsedList = new HashMap<>();
		isRepeat = new boolean[forms.size()];

		checkRepeat(forms);

		for (int i = 0; i < isRepeat.length; i++) {
			String email = forms.get(i).get(0);
			if (isRepeat[i] && !answer.contains(email)) {
				answer.add(email);
			}
		}

		Collections.sort(answer);

		return answer;
	}

	private static void checkRepeat(List<List<String>> forms) {
		List<String> tempList;
		for (int i = 0; i < forms.size(); i++) {
			tempList = forms.get(i);
			if (isDomainTure(tempList.get(0))) {
				checkRepeatName(tempList.get(1), i);
			}
		}
	}

	private static void checkRepeatName(String name, int index) {
		int left = 2;
		while (name.length() >= left) {
			String nameSub = name.substring(left - 2, left);
			checkRepeatNameSub(nameSub, index);
			left++;
		}
	}

	private static void checkRepeatNameSub(String nameSub, int index) {
		if (UsedList.containsKey(nameSub)) {
			isRepeat[UsedList.get(nameSub)] = true;
			isRepeat[index] = true;
		} else {
			UsedList.put(nameSub, index);
		}
	}

	private static boolean isDomainTure(String s) {
		return s.endsWith(DOMAINTYPE);
	}

}
