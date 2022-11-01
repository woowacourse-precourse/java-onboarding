package onboarding.nicknamevalidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NickNameValidator {

	private final List<Crew> crews;

	private final Map<String, Integer> occurrences;

	public NickNameValidator(List<List<String>> forms) {
		this.crews = new ArrayList<>();
		this.occurrences = new HashMap<>();
		initCrewsWith(forms);
		initOccurrences();
	}

	private void initCrewsWith(final List<List<String>> forms) {
		for (List<String> form : forms) {
			Crew crew = new Crew(form.get(0), form.get(1));
			crews.add(crew);
		}
	}

	private void initOccurrences() {
		for (Crew crew : crews) {
			initOccurrenceWith(crew.getNickname());
		}
	}

	private void initOccurrenceWith(final String nickname) {
		for (String word : getWordsOf(nickname)) {
			occurrences.merge(word, 1,
				(occurrences, ignored) -> occurrences + 1);
		}
	}

	private Set<String> getWordsOf(final String nickname) {
		Set<String> words = new HashSet<>();
		for (int i = 0; i < nickname.length() - 1; i++) {
			words.add(nickname.substring(i, i + 2));
		}
		return words;
	}

	public List<String> getInvalidEmails() {
		return occurrences.keySet()
			.stream()
			.filter(this::isDuplicatedWord)
			.map(this::getEmailsMatches)
			.flatMap(Collection::stream)
			.distinct()
			.sorted()
			.collect(Collectors.toList());
	}

	private boolean isDuplicatedWord(final String word) {
		return getOccurrenceOf(word) >= 2;
	}

	int getOccurrenceOf(final String word) {
		return occurrences.getOrDefault(word, 0);
	}

	List<String> getEmailsMatches(final String word) {
		return crews.stream()
			.filter(crew -> crew.isNicknameContains(word))
			.map(Crew::getEmail)
			.collect(Collectors.toList());
	}
}
