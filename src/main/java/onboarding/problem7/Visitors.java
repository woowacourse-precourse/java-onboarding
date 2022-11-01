package onboarding.problem7;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Visitors {

	private List<String> visitors;

	public Visitors(List<String> visitors) {
		this.visitors = visitors;
	}

	public int countVisit(String user) {
		int count = 0;
		for (String visitor : visitors) {
			if (user.equals(visitor)) {
				count += 1;
			}
		}
		return count;
	}

	public Set<String> getKnownUsers() {
		return new HashSet<>(visitors);
	}
}
