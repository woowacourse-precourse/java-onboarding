package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

	public static boolean[] duplicateUser;

	public static List<String> solution(List<List<String>> forms) {
		duplicateUser = new boolean[forms.size()];
		List<String> answer = new ArrayList<>();

		for (int i = 0; i < forms.size() - 1; i++) {
			List<String> form = forms.get(i);
			checkDuplicate(forms, form, i);
		}
		addDuplicateUser(answer);
		return answer;
	}

	public static void checkDuplicate(List<List<String>> forms, List<String> form, int index) {

	}

	public static boolean isDuplicateNickName(String formsNickname, String formNickname) {

		return false;
	}

	public static void addDuplicateUser(List<String> answer) {

	}
}
