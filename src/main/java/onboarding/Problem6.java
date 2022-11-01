package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {

		List<String> answer = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();

		for (List<String> list : forms) {
			String email = list.get(0), id = list.get(1);
			for (int i = 0; i < id.length() - 1; i++) {
				String piece = id.substring(i, i + 2);
				if (map.get(piece) >= 2 && !answer.contains(email)) {
					answer.add(email);
					break;
				}
			}
		}

		return answer;
	}


}