package onboarding.problem6;

import java.util.LinkedHashSet;
import java.util.Set;

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
}
