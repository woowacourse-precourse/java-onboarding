package onboarding.problem6;

import java.util.List;
import java.util.Set;

public class Crew {
	private final String email;
	private final Set<String> splitNames;

	public Crew(List<String> form) {
		this.email = form.get(0);
		this.splitNames = Splitter.splitTwoChar(form.get(1));
	}

	public String getEmail() {
		return email;
	}

	public Set<String> getSplitNames() {
		return splitNames;
	}
}
