package onboarding.friendrecommendationsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Crews {

	private static final int MIN_CREW_NUMBER = 1;

	private static final int MAX_CREW_NUMBER = 10_000;

	private final List<Crew> crews;

	private final Map<String, Set<Crew>> duplicateNicknameMap;

	public Crews(final List<List<String>> forms) {
		validateForms(forms);
		this.crews = new ArrayList<>();
		this.duplicateNicknameMap = new HashMap<>();
		initCrewsWith(forms);
	}

	private void initCrewsWith(final List<List<String>> forms) {
		forms.forEach(form -> {
			String email = form.get(0);
			String nickname = form.get(1);
			crews.add(new Crew(nickname, email));
		});
	}

	private void validateForms(final List<List<String>> forms) {
		Objects.requireNonNull(forms);
		int numberOfCrews = forms.size();

		if (isOutOfBound(numberOfCrews)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isOutOfBound(final int numberOfCrews) {
		return MIN_CREW_NUMBER > numberOfCrews
			|| numberOfCrews > MAX_CREW_NUMBER;
	}

	public Map<String, Set<Crew>> getCrewsOfDuplicateNickname() {
		for (Crew crew : crews) {
			getDuplicatePartsOfNickname(crew);
		}
		return duplicateNicknameMap;
	}

	private void getDuplicatePartsOfNickname(final Crew crew) {
		for (String partOfNickname : crew.getPartsOfName()) {
			duplicateNicknameMap.computeIfAbsent(
				partOfNickname,
				k -> new HashSet<>()
			).add(crew);
		}
	}
}
