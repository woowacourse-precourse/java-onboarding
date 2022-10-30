package onboarding;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		HashMap<String, String> crewHashData = new HashMap<>();
		for (List<String> form : forms) {
			crewHashData.put(form.get(0), form.get(1));
		}

		Collection<String> crewNicknames = crewHashData.values();

		for (String name : crewNicknames) {
			for (int j = 0; j <= name.length() - 2; j++) {
				String checkingWords = name.substring(j, j + 2);
				System.out.println(checkingWords);
			}
		}

		List<String> answer = List.of("answer");
		return answer;
	}
}
