package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();

		Map<String, List<String>> friendList = new HashMap<>();
		for (List<String> f : friends) {
			friendList.computeIfAbsent(f.get(0), s -> new ArrayList<>()).add(f.get(1));
			friendList.computeIfAbsent(f.get(1), s -> new ArrayList<>()).add(f.get(0));
		}

        return answer;
    }
}
