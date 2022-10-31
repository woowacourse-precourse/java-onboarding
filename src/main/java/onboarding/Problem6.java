package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> emails = new ArrayList<>();
		for (int i = 0; i < forms.size() - 1; i++) {
			List<String> form = forms.get(i);

			String email1 = form.get(0);
			String name1 = form.get(1);
			for (int j = i + 1; j < forms.size(); j++) {
				List<String> compareWithForm = forms.get(j);

				String email2 = compareWithForm.get(0);
				String name2 = compareWithForm.get(1);

				if (name1.length() < 2)
					continue;

				if (isDuplicated(name1, name2)) {
					if (!emails.contains(email1)) {
						emails.add(email1);
					}
					if (!emails.contains(email2)) {
						emails.add(email2);
					}

				}
			}
		}
		emails.sort(Comparator.naturalOrder());

		return emails;
	}

	public static boolean isDuplicated(String name1, String name2) {
		for (int i = 0; i < name1.length() - 1; i++) {
			String tmp = name1.substring(i, i + 2);
			if (name2.contains(tmp))
				return true;
		}
		return false;
	}
}