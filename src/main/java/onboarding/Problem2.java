package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

class validationSamethings {
	public static int validation(ArrayList<String> list) {
		String pivot;
		for (int i = 0; i < list.size() - 1; i++) {
			pivot = list.get(i);
			if (pivot.equals(list.get(i + 1))) {
				return i;
			}
		}
		return -1;
	}
}

class removeSamethings {
	public static String removeSameElement(ArrayList<String> list, int index) {
		String strArrayToString;
		String startElement;
		int start = index;
		startElement = list.get(start);
		for (int i = start + 1; i < list.size(); i++) {
			if (startElement.equals(list.get(i))) {
				list.remove(i);
				continue;
			}
			break;
		}
		list.remove(start);

		strArrayToString = String.join("", list);
		return strArrayToString;
	}
}

class invalidStringException {
	public static boolean invalidString(String string) {
		if (string.length() < 1 || string.length() > 1000) {
			return true;
		}
		if (!string.equals(string.toLowerCase())) {
			return true;
		}
		if (!string.chars().allMatch(Character::isLetter)) {
			return true;
		}
		return false;
	}
}

public class Problem2 {
	public static String solution(String cryptogram) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(cryptogram.split("")));
		String answer = cryptogram;
		int index;
		if (!invalidStringException.invalidString(cryptogram)) {
			while ((index = validationSamethings.validation(list)) != -1) {
				answer = removeSamethings.removeSameElement(list, index);
			}
		}
		return answer;
	}
}
