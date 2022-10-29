package onboarding.problem6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Verifier {
	private static boolean isDuplicate(Crew crewOne, Crew crewTwo) {
		if (crewOne == crewTwo) {
			return false;
		}

		Set<String> crewOneNames = new LinkedHashSet<>(crewOne.getSplitNames());
		Set<String> crewTwoNames = new LinkedHashSet<>(crewTwo.getSplitNames());
		crewOneNames.retainAll(crewTwoNames);
		if (crewOneNames.size() != 0) {
			return true;
		}
		return false;
	}

	public static List<String> extractDuplicateCrews(List<List<String>> forms) {
		Set<String> result = new LinkedHashSet<>();
		List<Crew> crews = Crew.createCrews(forms);

		for (Crew crewOne : crews) {
			for (Crew crewTwo : crews) {
				if (isDuplicate(crewOne, crewTwo)) {
					result.add(crewOne.getEmail());
					break;
				}
			}
		}

		return result.stream().sorted().collect(Collectors.toList());
	}

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
}
