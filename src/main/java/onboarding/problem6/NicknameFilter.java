package onboarding.problem6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NicknameFilter {

	public List<String> filter(Set<Crew> crewSet) {
		List<Crew> crewList = new ArrayList<>(crewSet);
		Set<String> filteredCrewSet = new HashSet<>();

		for (int i = 0; i < crewList.size(); i++) {
			String nickname = crewList.get(i).getNickname();
			Set<String> nicknamePattern = createNicknamePattern(nickname);

			for (int j = 0; j < crewList.size(); j++) {
				if (i == j) {
					continue;
				}
				Crew target = crewList.get(j);

				if (isDuplicatedPattern(nickname, nicknamePattern) || nickname.equals(target.getNickname())) {
					filteredCrewSet.add(target.getEmail());
				}
			}
		}
		return filteredCrewSet
				.stream()
				.sorted()
				.collect(Collectors.toList());
	}

	private boolean isDuplicatedPattern(String nickname, Set<String> nicknamePattern) {
		if (nicknamePattern.size() == 0) {
			return false;
		}

		for (String pattern : nicknamePattern) {
			if (nickname.contains(pattern)) {
				return true;
			}
		}
		return false;
	}

	private HashSet<String> createNicknamePattern(String nickname) {
		if (nickname.length() == 1) {
			return new HashSet<>();
		}

		String[] split = nickname.split("");

		HashSet<String> nicknamePattern = new HashSet<>();
		int startIndex = 0;

		while (true) {
			nicknamePattern.add(split[startIndex] + split[startIndex + 1]);
			if (startIndex == split.length - 2) {
				break;
			}
			startIndex++;
		}
		return nicknamePattern;
	}
}
