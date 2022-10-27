package onboarding.problem6;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Crew {
	private final String email;
	private final Set<String> splitNames;

	private Crew(List<String> form) {
		this.email = form.get(0);
		this.splitNames = Splitter.splitTwoChar(form.get(1));
	}

	public static Crew createFrom(List<String> form) {
		return new Crew(form);
	}

	public static List<Crew> createCrews(List<List<String>> forms) {
		return forms.stream().map(Crew::createFrom).collect(Collectors.toList());
	}

	public String getEmail() {
		return email;
	}

	public Set<String> getSplitNames() {
		return splitNames;
	}
}
