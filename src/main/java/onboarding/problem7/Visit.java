package onboarding.problem7;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Visit {

	private List<String> visitors;

	public Visit(List<String> visitors) {
		this.visitors = visitors;
	}

	public int count(String user) {
		int count = 0;
		for (String visitor : visitors) {
			if (user.equals(visitor)) {
				count += 1;
			}
		}
		return count;
	}

	public Set<String> getVisitors() {
		return new HashSet<>(visitors);
	}
}
