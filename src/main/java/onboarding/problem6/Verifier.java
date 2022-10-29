package onboarding.problem6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Verifier {
	private static Set<String> checkDuplicate(Map<String, String> crewsSplitNameMap, Crew crew) {
		Set<String> duplicateCrewsEmail = new HashSet<>();
		for (String splitName : crew.getSplitNames()) {
			if (crewsSplitNameMap.containsKey(splitName)) {
				duplicateCrewsEmail.add(crew.getEmail());
				duplicateCrewsEmail.add(crewsSplitNameMap.get(splitName));
			} else {
				crewsSplitNameMap.put(splitName, crew.getEmail());
			}
		}
		return duplicateCrewsEmail;
	}

	public static List<String> extractDuplicateCrews(List<List<String>> forms) {
		Set<String> result = new HashSet<>();
		Map<String, String> crewsSplitNameMap = new HashMap<>();

		List<Crew> crews = Crew.createCrews(forms);
		for (Crew crew : crews) {
			Set<String> duplicateCrewsEmail = checkDuplicate(crewsSplitNameMap, crew);
			result.addAll(duplicateCrewsEmail);
		}

		return result.stream().sorted().collect(Collectors.toList());
	}
}
