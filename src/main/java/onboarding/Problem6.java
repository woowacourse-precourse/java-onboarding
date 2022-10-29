package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		HashMap<String, String> crewHashData = new HashMap<>();
		for (List<String> form : forms) {
			crewHashData.put(form.get(0), form.get(1));
		}
		List<String> answer = List.of("answer");
		return answer;
	}
}
