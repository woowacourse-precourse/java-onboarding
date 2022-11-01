package onboarding.problem6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicationCheckerImp implements DuplicationChecker {

	private boolean checkDuplication(String nickname1, String nickname2) {
		for (int i = 0; i < nickname1.length() - 1; i++) {
			if (nickname2.contains(nickname1.substring(i, i + 2))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Crew> getDuplicatedCrews(List<Crew> crews) {
		Set<Crew> duplicatedCrews = new HashSet<>();
		for (int i = 0; i < crews.size(); i++) {
			for (int j = i + 1; j < crews.size(); j++) {
				if (checkDuplication(crews.get(i).getNickname(), crews.get(j).getNickname())) {
					duplicatedCrews.add(crews.get(i));
					duplicatedCrews.add(crews.get(j));
				}
			}
		}
		return new ArrayList<Crew>(duplicatedCrews);
	}
}
