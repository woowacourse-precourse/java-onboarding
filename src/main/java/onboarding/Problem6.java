package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
	private static int findMin(int num1, int num2) {
		if (num1 > num2) {
			return num2;
		}
		return num1;
	}

	private static boolean checkTwoChar(String str1, String str2) {
		int flag;
		int range = findMin(str1.length(), str2.length());
		for (int i = 0; i + 1 < range; i++) {
			for (int j = 0; j + 1 < str2.length(); j++) {
				flag = 1;
				for (int idx = 0; idx < 2; idx++) {
					if (str1.charAt(i + idx) != str2.charAt(j + idx)) {
						flag = 0;
						break;
					}
				}
				if (flag == 1) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean checkRepeat(int i, List<List<String>> forms) {
		int length = forms.size();
		for (int j = 0; j < length; j++) {
			if (j != i && checkTwoChar(forms.get(j).get(1), forms.get(i).get(1))) {
				return true;
			}
		}
		return false;
	}

	public static List<String> solution(List<List<String>> forms) {
		int length = forms.size();
		List<String> answer = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			if (checkRepeat(i, forms)) {
				answer.add(forms.get(i).get(0));
			}
		}
		answer.sort(Comparator.naturalOrder());
		return answer;
	}
}
