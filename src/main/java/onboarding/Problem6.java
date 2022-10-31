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
		addDuplicateUser(answer, forms);
		return answer;
	}

	public static void checkDuplicate(List<List<String>> forms, List<String> form, int index) {
		String formNickname = form.get(1);
		for (int i = index + 1; i < forms.size(); i++) {
			String formsNickname = forms.get(i).get(1);
			if (isDuplicateNickName(formsNickname, formNickname)) {
				duplicateUser[i] = true;
				duplicateUser[index] = true;
			}
		}
	}

	public static boolean isDuplicateNickName(String formsNickname, String formNickname) {
		for (int i = 0; i < formNickname.length() - 1; i++) {
			String subNickname = formNickname.substring(i, i + 2);
			if (formsNickname.contains(subNickname)) {
				return true;
			}
		}
		return false;
	}

	public static void addDuplicateUser(List<String> answer, List<List<String>> forms) {
		
	}
}
