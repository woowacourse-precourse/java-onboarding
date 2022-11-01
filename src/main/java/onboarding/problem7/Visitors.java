package onboarding.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Visitors {

	private static final Map<String, Integer> visitors = new HashMap<>();

	public static void init(List<String> inputVisitorsId) {
		for (String inputVisitorId : inputVisitorsId) {
			User user = new User(inputVisitorId);
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
