package onboarding.problemsix.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Woowacourse {

	private HashMap<String, List<String>> crewMap = new HashMap<>();

	public Woowacourse(List<List<String>> forms) {

		for (List<String> form : forms) {
			String email = form.get(0);
			String nickname = form.get(1);

			if (crewMap.containsKey(nickname)) {
				crewMap.get(nickname).add(email);
			} else if (!crewMap.containsKey(nickname)) {
				crewMap.put(nickname, new ArrayList<>());
			}

		}

	}

}
