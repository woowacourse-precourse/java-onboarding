package onboarding.problem6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JoinFormUtils {

	private final Map<String, String> joinNickNames = new HashMap<>();
	private final Set<String> duplicateNickNames = new HashSet<>();

	public void join(String input) {
		for (int startIndex = 0; input.length() - startIndex >= 2; startIndex++) {
			join(input, startIndex);
		}
	}

	void join(String input, int startIndex) {
		for (int endIndex = startIndex + 2; endIndex <= input.length(); endIndex++) {
			String substring = input.substring(startIndex, endIndex);
			if (joinNickNames.containsKey(substring)) {
				duplicateNickNames.add(input);
				duplicateNickNames.add(joinNickNames.get(substring));
				continue;
			}
			joinNickNames.put(substring, input);
		}
	}

	public Set<String> getDuplicateNickNames() {
		return duplicateNickNames;
	}
}
