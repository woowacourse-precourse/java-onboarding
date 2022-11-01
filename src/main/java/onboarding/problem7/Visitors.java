package onboarding.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Visitors {

	private static Map<String, Integer> visitors;

	public static void init(List<String> inputVisitorsId) {
		visitors = new HashMap<>();
		for (String inputVisitorId : inputVisitorsId) {
			new User(inputVisitorId);
			visitors.put(inputVisitorId, visitors.getOrDefault(inputVisitorId, 0) + 1);
		}
	}

	public static Integer getVisitCount(String visitorId) {
		if (visitors.containsKey(visitorId)) {
			return visitors.get(visitorId);
		}
		return 0;
	}
}
