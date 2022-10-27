package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {

	public static List<String> solution(List<List<String>> forms) {
		TreeSet<String> emailSet = new TreeSet<>();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < forms.size(); i++) {
			String nickname = forms.get(i).get(1);

			if (nickname.length() < 2) {
				break;
			}

			for (int j = 0; j < nickname.length() - 1; j++) {
				String key = nickname.substring(j, j + 2);
				String formsEmail = forms.get(i).get(0);
				if (map.containsKey(key)) {
					final String email = map.get(key);
					if (!email.equals(formsEmail)) {
						emailSet.add(email);
						emailSet.add(formsEmail);
					}
				}
				map.put(key, formsEmail);
			}

		}
		return new ArrayList<>(emailSet);
	}

}
